package hu.unideb.shoppinglist.pages.fragments.productdetail

import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.unideb.shoppinglist.database.dao.ProductDao

class ProductDetailViewModelFactory(
    private val productId: Long,
    private val dataSource: ProductDao
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductDetailViewModel::class.java)) {
            return ProductDetailViewModel(productId, dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}