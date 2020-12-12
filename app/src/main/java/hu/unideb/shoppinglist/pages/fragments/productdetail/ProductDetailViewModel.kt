package hu.unideb.shoppinglist.pages.fragments.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import hu.unideb.shoppinglist.database.dao.ProductDao
import hu.unideb.shoppinglist.database.model.Product
import kotlinx.coroutines.Job

class ProductDetailViewModel(productId: Long = 0L, dataSource: ProductDao) :
    ViewModel() {

    val database = dataSource

    private val viewModelJob = Job()

    private val product: LiveData<Product>

    fun getProduct() = product

    init {
        product = database.getProductWithId(productId)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}