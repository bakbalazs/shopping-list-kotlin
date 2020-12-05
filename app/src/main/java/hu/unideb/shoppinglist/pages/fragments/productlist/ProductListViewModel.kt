package hu.unideb.shoppinglist.pages.fragments.productlist

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.unideb.shoppinglist.database.dao.ProductDao
import hu.unideb.shoppinglist.database.model.Product
import kotlinx.coroutines.launch

class ProductListViewModel(dataSource: ProductDao, application: Application) : ViewModel() {

    var database = dataSource

    val products = database.getAllProducts()


    fun insertData(product: Product) {
        viewModelScope.launch {
            database.insert(product)
        }
    }

}