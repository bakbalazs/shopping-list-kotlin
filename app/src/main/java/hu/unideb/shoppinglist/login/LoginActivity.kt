package hu.unideb.shoppinglist.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.ktx.auth
//import com.google.firebase.ktx.Firebase
import hu.unideb.shoppinglist.R
import hu.unideb.shoppinglist.pages.HomeActivity
import hu.unideb.shoppinglist.registration.RegistrationActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var context: Context

    lateinit var loginViewModel: LoginViewModel

    private var auth: FirebaseAuth = Firebase.auth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        context = this@LoginActivity

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

//        button2.setOnClickListener {
////            loginViewModel.insert(context, "Teszt1")
////            loginViewModel.insert(context, "ASDAasd")
//            auth.signInWithEmailAndPassword(email_edit.text.toString(), editTextTextPassword3.text.toString())
//                .addOnCompleteListener { task ->
////
//                    if (task.isSuccessful) {
////                        println("yeeeee")
//                        val user = auth.currentUser
//
//                        Log.d("ASDDAS", user?.email.toString())
//                        val intentAct: Intent = Intent(context, HomeActivity::class.java)
//                        if(user != null) {
//                            intentAct.putExtra("TEST", user);
//
//                        }
//
//                        context.startActivity(intentAct)
////                    success = true
////                    _success.value = true
//
//                    } else {
//                        println(task.exception)
////                errorMessage = "Hibaaa van"
////                        errorMessage.value = "Hibaa"
////                    success = false
////                    _success.value = false
//                    }
//
//
//                }
//        }

        login_page_reg_button.setOnClickListener {
            val intentAct: Intent = Intent(context, RegistrationActivity::class.java)
        context.startActivity(intentAct)
//        Log.d("sad" ,"KATTTTTT")
        }
//
//    textView3.setOnClickListener {
//        val intentAct: Intent = Intent(context, RegistrationActivity::class.java)
//        context.startActivity(intentAct)
//        Log.d("sad" ,"KATTTTTT")
//    }
//
//        button3.setOnClickListener {
//
//            loginViewModel.getAll(context)
//
//            loginViewModel.liveDataLogin?.map {
//
//                Log.d("adaasdas", it.productName);
//            }


//            loginViewModel.liveDataLogin?.observe(this, Observer  {
//
//                Log.d("TAG", it.toString())
//            })

//            val list =loginViewModel.getAll(context)

//            list?.observe(this, (product -> {
//
//        })
//            print()
//        }

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