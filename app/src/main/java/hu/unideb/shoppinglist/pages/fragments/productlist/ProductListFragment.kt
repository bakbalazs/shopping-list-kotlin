package hu.unideb.shoppinglist.pages.fragments.productlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import hu.unideb.shoppinglist.R
import hu.unideb.shoppinglist.database.AppDatabase
import hu.unideb.shoppinglist.database.model.Product
import hu.unideb.shoppinglist.databinding.FragmentProductListBinding
import kotlinx.android.synthetic.main.fragment_product_list.*

class ProductListFragment : Fragment() {

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

        val adapter = ProductListAdapter()

        binding.productList.adapter = adapter

        productListViewModel.products.observe(viewLifecycleOwner, {
            it?.let {
                adapter.data = it
            }
        })

        binding.lifecycleOwner = this

        binding.button4.setOnClickListener {
            val product = Product(editTextTextPersonName.text.toString())
            productListViewModel.insertData(product)
        }
        return binding.root

    }


}