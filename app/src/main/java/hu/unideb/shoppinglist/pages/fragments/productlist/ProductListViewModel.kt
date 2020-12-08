package hu.unideb.shoppinglist.pages.fragments.productlist

import android.app.Application
import android.view.animation.Transformation
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.unideb.shoppinglist.database.dao.ProductDao
import hu.unideb.shoppinglist.database.model.Product
import kotlinx.coroutines.launch

class ProductListViewModel(dataSource: ProductDao, application: Application) : ViewModel() {

    var database = dataSource

    val products = database.getAllProducts()

    val productString = Transformations.map(products) { products ->
        formatProductList(products)
    }

    fun insertData(product: Product) {
        viewModelScope.launch {
            database.insert(product)
        }
    }

    private val _navigateToProductDetail = MutableLiveData<Long>()
    val navigateToSleepDetail
        get() = _navigateToProductDetail

    fun onProductClicked(id: Long) {
        _navigateToProductDetail.value = id
    }

    fun onProductDetailNavigated() {
        _navigateToProductDetail.value = null
    }

    fun doneNavigating() {
        _navigateToProductDetail.value = null
    }

}