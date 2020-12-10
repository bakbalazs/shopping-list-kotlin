package hu.unideb.shoppinglist.pages.fragments.productlist

import android.app.Application
import android.util.Log
import android.view.animation.Transformation
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.unideb.shoppinglist.database.dao.ProductDao
import hu.unideb.shoppinglist.database.model.Product
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class ProductListViewModel(dataSource: ProductDao, application: Application, userId: String) :
    ViewModel() {

    var database = dataSource

//    val products = database.getAllProducts()

    val products = database.getAllProductsByUserId(userId)

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

    fun onChecked(product: Product) {
        viewModelScope.launch {
            product.purchased = product.purchased != true
            database.update(product)
        }
    }
}