package hu.unideb.shoppinglist.login

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import hu.unideb.shoppinglist.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var context: Context

    lateinit var loginViewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        context = this@LoginActivity

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        button2.setOnClickListener {
            loginViewModel.insert(context, "ASDAasd")
        }

        button3.setOnClickListener {

            loginViewModel.getAll(context)

            loginViewModel.liveDataLogin?.map {

                Log.d("adaasdas", it.productName);
            }


//            loginViewModel.liveDataLogin?.observe(this, Observer  {
//
//                Log.d("TAG", it.toString())
//            })

//            val list =loginViewModel.getAll(context)

//            list?.observe(this, (product -> {
//
//        })
//            print()
        }

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
//
//        val application = requireNotNull(this).application
//        val dataSource = AppDatabase.getInstance(application).productDatabaseDao
//        val viewModelFactory = LoginViewModelFactory(dataSource, application)
//
//
//        val productViewModel =
//            ViewModelProvider(
//                this, viewModelFactory
//            ).get(LoginViewModel::class.java)
//
//
//        binding.loginViewModel = productViewModel
//
//        binding.setLifecycleOwner(this)
    }
}