package hu.unideb.shoppinglist.pages.fragments.productdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import hu.unideb.shoppinglist.R
import hu.unideb.shoppinglist.database.AppDatabase
import hu.unideb.shoppinglist.databinding.FragmentProductDetailBinding

class ProductDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentProductDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_detail, container, false)

        val application = requireNotNull(this.activity).application
        val arguments = ProductDetailFragmentArgs.fromBundle(requireArguments())

        val dataSource = AppDatabase.getInstance(application).productDatabaseDao
        val viewModelFactory = ProductDetailViewModelFactory(arguments.productId, dataSource)

        val productDetailViewModel = ViewModelProvider(this,viewModelFactory).get(ProductDetailViewModel::class.java)

        binding.productDetailViewModel = productDetailViewModel

        binding.lifecycleOwner = this

//        productDetailViewModel.navigateToProducts.observe(this, {
//            if(it == true) {
//
//
////                this.findNavController().navigate(ProductDetailFragmentDirections.)
//            }
//        })

        return binding.root
    }
}