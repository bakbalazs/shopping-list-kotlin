package hu.unideb.shoppinglist.pages.fragments.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.unideb.shoppinglist.database.dao.ProductDao

class ProductListViewModelFactory(
    private val dataSource: ProductDao,
    private val userId: String
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductListViewModel::class.java)) {
            return ProductListViewModel(dataSource, userId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}