package hu.unideb.shoppinglist.pages.fragments.productdetail

import androidx.lifecycle.ViewModel
import hu.unideb.shoppinglist.database.dao.ProductDao

class ProductDetailViewModel(private val productKey: Long = 0L, dataSource: ProductDao) :
    ViewModel() {
}