package hu.unideb.shoppinglist.pages.fragments.productlist

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
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
import java.util.*

class ProductListFragment : BaseFragment() {
    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentProductListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_product_list, container, false
        )
        val userId = ACTIVITY.userId

        val application = requireNotNull(this.activity).application

        val dataSource = AppDatabase.getInstance(application).productDatabaseDao

        val viewModelFactory = ProductListViewModelFactory(dataSource, userId)

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

        DividerItemDecoration(
            context,
            LinearLayoutManager.VERTICAL
        ).apply {
            binding.productList.addItemDecoration(this)
        }

        productListViewModel.products.observe(viewLifecycleOwner, {
            it?.let {
                adapter.addHeaderAndSubmitList(it)
            }
        })

        binding.lifecycleOwner = this

        productListViewModel.navigateToSleepDetail.observe(viewLifecycleOwner, { product ->
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
                    productQuantity = mDialogView.piece.text.toString().toInt(),
                    shopName = mDialogView.shop_name.text.toString(),
                    addDate = currentDateAndTime,
                    userId = userId
                )
                productListViewModel.insertData(product)
            }

        }
        return binding.root

    }

}