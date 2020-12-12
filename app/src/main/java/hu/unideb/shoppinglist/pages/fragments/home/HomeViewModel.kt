package hu.unideb.shoppinglist.pages.fragments.home

import androidx.lifecycle.ViewModel
import hu.unideb.shoppinglist.database.dao.ProductDao

class HomeViewModel(dataSource: ProductDao, userId: String, userEmail: String) :
    ViewModel() {
    var database = dataSource

    val products = database.getAllProductsByUserId(userId)
    val purchasedProducts = database.getPurchasedProduct(userId)

    val email = userEmail
}