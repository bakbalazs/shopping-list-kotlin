package hu.unideb.shoppinglist.pages.fragments.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hu.unideb.shoppinglist.database.dao.ProductDao
import hu.unideb.shoppinglist.database.model.Product
import kotlinx.coroutines.Job

class ProductDetailViewModel(private val productId: Long = 0L, dataSource: ProductDao) :
    ViewModel() {

    val databse = dataSource

    private val viewModelJob = Job()

    private val product: LiveData<Product>

    fun getProduct() = product

    init {
        product = databse.getProductWithId(productId)
    }

    private val _navigateToProducts = MutableLiveData<Boolean?>()

    val navigateToProducts: LiveData<Boolean?>
        get() = _navigateToProducts

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun doneNavigating(){
        _navigateToProducts.value = null
    }

    fun onClose() {
        _navigateToProducts.value = null
    }
}