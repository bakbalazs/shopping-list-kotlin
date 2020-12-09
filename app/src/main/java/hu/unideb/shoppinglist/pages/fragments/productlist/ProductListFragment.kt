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
import kotlinx.android.synthetic.main.product_list_header.view.*
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class ProductListFragment : BaseFragment() {
    private lateinit var database: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentProductListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_product_list, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = AppDatabase.getInstance(application).productDatabaseDao

        val viewModelFactory = ProductListViewModelFactory(dataSource, application)

        val productListViewModel =
            ViewModelProvider(this, viewModelFactory).get(ProductListViewModel::class.java)

        binding.productListViewModel = productListViewModel

        val adapter = ProductListAdapter(ProductClickListener { productId ->
            productListViewModel.onProductClicked(productId)
        })

        binding.productList.adapter = adapter

        productListViewModel.products.observe(viewLifecycleOwner, {
            it?.let {
                adapter.addHeaderAndSubmitList(it)
            }
        })

        binding.lifecycleOwner = this

        productListViewModel.navigateToSleepDetail.observe(viewLifecycleOwner, Observer { product ->
            product?.let {

                Log.d("asddasasd", product.toString())
                this.findNavController().navigate(
                    ProductListFragmentDirections.actionNavProductsToNavProductDetails(product)
                )

                productListViewModel.onProductDetailNavigated()

            }
        })
        database = Firebase.database.reference

        val incomingText = ACTIVITY.userId
//        println("Incoming text: "+incomingText)
//        val bundle:Bundle = get;
//        this.getA

//        var userid:String = ""
//        arguments?.let {
//            userid = it.getString("userId")!!
//        }


//        activity.result

//        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
//        val currentDate = sdf.format(Date())
//        val currentDate = LocalDate.now()
        val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss")
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        binding.button4.setOnClickListener {
            val mDialogView = LayoutInflater.from(context).inflate(R.layout.create_product_dialog, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this@ProductListFragment.requireContext())
                .setView(mDialogView)
                .setCustomTitle(LayoutInflater.from(context).inflate(R.layout.dialog_title, null,false))

            //show dialog
            val  mAlertDialog = mBuilder.show()
            //login button click of custom layout
            mDialogView.button.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()
                //get text from EditTexts of custom layout
//                val name = mDialogView.dialogNameEt.text.toString()
//                val email = mDialogView.dialogEmailEt.text.toString()
//                val password = mDialogView.dialogPasswEt.text.toString()
                //set the input text in TextView
//                mainInfoTv.setText("Name:"+ name +"\nEmail: "+ email +"\nPassword: "+ password)

                val product = Product(
                id = Timestamp(System.currentTimeMillis()).time,
                productName = mDialogView.productt_name.text.toString(),
                productPiece = 2,
                shopName = mDialogView.editTextTextPersonName4.text.toString(),
                addDate = currentDateAndTime
            )
                productListViewModel.insertData(product)
                val newData2 =
                    database.child("household").child("products").push()
                newData2.setValue(product)
            }
            //cancel button click of custom layout
//            mDialogView.dialogCancelBtn.setOnClickListener {
//                //dismiss dialog
//                mAlertDialog.dismiss()
//            }




//            productListViewModel.insertData(product)
//
//            productListViewModel.insertData(product)

//            val newData = database.child("products").child(incomingText).push()
//            newData.setValue( product)

//            val users: ArrayList<String>? = null

//            users.toMutableList().add(incomingText)
//            users?.add(incomingText)

//            val list = arrayListOf<String>()
//            list.add(incomingText)
//            val list2 = arrayListOf<Product>()
//
//            list2.add(product)
//
//            val household = HouseHold(
//                householdName = "Teszt",
//                userIds = list,
//                products = list2
//            )
//


        }
        return binding.root

    }

}