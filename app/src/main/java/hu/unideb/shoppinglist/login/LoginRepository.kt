package hu.unideb.shoppinglist.login

import android.content.Context
import androidx.lifecycle.LiveData
import hu.unideb.shoppinglist.database.AppDatabase
import hu.unideb.shoppinglist.database.model.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginRepository {

    companion object {

        var loginDatabase: AppDatabase? = null

        var loginTableModel: LiveData<List<Product>>? = null

        fun initializeDB(context: Context): AppDatabase {
            return AppDatabase.getInstance(context)
        }
//
        fun insertData(context: Context, productNAme: String) {

            loginDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                val loginDetails = Product(productName = productNAme)
                loginDatabase!!.productDatabaseDao.insert(loginDetails)
            }

        }

//        fun getLoginDetails(context: Context): LiveData<List<Product>>? {
//
//            loginDatabase = initializeDB(context)
//
//            loginTableModel = loginDatabase!!.productDatabaseDao.getAllProducts()
//
//            return loginTableModel
//        }

    }
}