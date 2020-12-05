package hu.unideb.shoppinglist.login

import android.content.Context
import androidx.lifecycle.ViewModel

class LoginViewModel() : ViewModel() {
//    var liveDataLogin: LiveData<List<Product>>? = null
//
    fun insert(context: Context, productName: String) {
        LoginRepository.insertData(context, productName)
    }
//
//    fun getAll(context: Context): LiveData<List<Product>>? {
//        liveDataLogin = LoginRepository.getLoginDetails(context)
//        return liveDataLogin
//    }

//    private val products = database.getAllProducts()

//    private suspend fun insert(product: Product) {
//        database.insert(product)
//    }

//    suspend fun insertData(context: Context, productname:String) {
//        database.insert(Product(productname))
//    }


//    init {
//        print("q23432324324322332432")
//        print(database.getAllProducts())
//    }

//    private var auth: FirebaseAuth = Firebase.auth
//
//    val email = MutableLiveData<String>()
//    val password = MutableLiveData<String>()
//    var errorMessage = MutableLiveData<String>()
//
//
//    fun login() {
//    viewModelScope.launch {


//        val newProduct = Product()
//
//        insert(newProduct)

//print("asdsadsaads")
//        print(products)
//        products.map {
//            print("&###############################x")
//            print(it[0])
//            print("&###############################x")
//
//        }
//        for(product in) {
//
//        }

//        for(int i=0;i<s; i++){
//
//                }

//        products.forEach {
//            it.productName
//        }


//        insert(product = Product(1, "tree"))

//    }
//        val context: Context = view.context;
//
//        auth.signInWithEmailAndPassword(email.value.toString(), password.value.toString())
//            .addOnCompleteListener { task ->
//
//                if (task.isSuccessful) {
//                    val intentAct: Intent = Intent(context, HomeActivity::class.java)
//                    context.startActivity(intentAct)
//                } else {
//                    println(task.exception)
//                    errorMessage.value = "Hibaa"
//                }
//            }

//    }
}