package hu.unideb.shoppinglist.pages.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.unideb.shoppinglist.database.dao.ProductDao

class HomeViewModelFactory(
    private val dataSource: ProductDao,
    private val userId: String,
    private val userEmail:String
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(dataSource, userId, userEmail) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}