package hu.unideb.shoppinglist.pages.fragments.productlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.unideb.shoppinglist.database.dao.ProductDao
import hu.unideb.shoppinglist.database.model.Product
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ProductListViewModel(dataSource: ProductDao, userId: String) :
    ViewModel() {

    var database = dataSource

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

    fun onChecked(product: Product) {
        viewModelScope.launch {

            if (!product.purchased) {
                product.purchased = true
                val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.ENGLISH)

                product.purchaseDate = simpleDateFormat.format(Date())
            } else {
                product.purchased = false
                product.purchaseDate = ""
            }

            database.update(product)
        }
    }
}