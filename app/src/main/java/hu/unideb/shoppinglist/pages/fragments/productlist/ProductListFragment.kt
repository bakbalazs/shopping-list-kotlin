package hu.unideb.shoppinglist.pages.fragments.productlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import hu.unideb.shoppinglist.R
import hu.unideb.shoppinglist.database.AppDatabase
import hu.unideb.shoppinglist.database.model.Product
import hu.unideb.shoppinglist.databinding.FragmentProductListBinding
import hu.unideb.shoppinglist.utils.BaseFragment
import kotlinx.android.synthetic.main.create_product_dialog.*
import kotlinx.android.synthetic.main.create_product_dialog.view.*
import kotlinx.android.synthetic.main.fragment_product_list.*
import kotlinx.android.synthetic.main.list_item_product.*
import kotlinx.android.synthetic.main.product_list_header.view.*
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class ProductListFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentProductListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_product_list, container, false
        )
        val incomingText = ACTIVITY.userId

        val application = requireNotNull(this.activity).application

        val dataSource = AppDatabase.getInstance(application).productDatabaseDao

        val viewModelFactory = ProductListViewModelFactory(dataSource, application, incomingText)

        val productListViewModel =
            ViewModelProvider(this, viewModelFactory).get(ProductListViewModel::class.java)

        binding.productListViewModel = productListViewModel

        val adapter = ProductListAdapter(
            ProductClickListener { productId ->
                productListViewModel.onProductClicked(productId)
            },
            ProductCheckBoxClickListener { product ->
                productListViewModel.onChecked(product)
            }
        )

        binding.productList.adapter = adapter

        productListViewModel.products.observe(viewLifecycleOwner, {
            it?.let {
                adapter.addHeaderAndSubmitList(it)
            }
        })

        binding.lifecycleOwner = this

        productListViewModel.navigateToSleepDetail.observe(viewLifecycleOwner, Observer { product ->
            product?.let {

                this.findNavController().navigate(
                    ProductListFragmentDirections.actionNavProductsToNavProductDetails(product)
                )

                productListViewModel.onProductDetailNavigated()

            }
        })

        val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.ENGLISH)
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        binding.button4.setOnClickListener {
            val mDialogView =
                LayoutInflater.from(context).inflate(R.layout.create_product_dialog, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this@ProductListFragment.requireContext())
                .setView(mDialogView)
                .setCustomTitle(
                    LayoutInflater.from(context).inflate(R.layout.dialog_title, null, false)
                )

            val mAlertDialog = mBuilder.show()
            mDialogView.create_button.setOnClickListener {
                mAlertDialog.dismiss()
                val product = Product(
                    id = Timestamp(System.currentTimeMillis()).time,
                    productName = mDialogView.name.text.toString(),
                    productPiece = mDialogView.piece.text.toString().toInt(),
                    shopName = mDialogView.shop_name.text.toString(),
                    addDate = currentDateAndTime,
                    userId = incomingText
                )
                productListViewModel.insertData(product)
            }

        }
        return binding.root

    }

}