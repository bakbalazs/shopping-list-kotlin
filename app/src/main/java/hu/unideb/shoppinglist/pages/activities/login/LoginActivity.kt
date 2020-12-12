package hu.unideb.shoppinglist.pages.activities.login

//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.ktx.auth
//import com.google.firebase.ktx.Firebase
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import hu.unideb.shoppinglist.R
import hu.unideb.shoppinglist.pages.activities.home.HomeActivity
import hu.unideb.shoppinglist.pages.activities.registration.RegistrationActivity
import kotlinx.android.synthetic.main.activity_login.*

//class LoginActivity : AppCompatActivity() {
//
//    private lateinit var loginViewModel: LoginViewModel
//    private var auth: FirebaseAuth = Firebase.auth
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContentView(R.layout.activity_login)
//
//        val username = findViewById<EditText>(R.id.username)
//        val password = findViewById<EditText>(R.id.password)
//        val login = findViewById<Button>(R.id.login)
//        val loading = findViewById<ProgressBar>(R.id.loading)
//
//        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
//            .get(LoginViewModel::class.java)
//
//        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
//            val loginState = it ?: return@Observer
//
//            // disable login button unless both username / password is valid
//            login.isEnabled = loginState.isDataValid
//
//            if (loginState.usernameError != null) {
//                username.error = getString(loginState.usernameError)
//            }
//            if (loginState.passwordError != null) {
//                password.error = getString(loginState.passwordError)
//            }
//        })
//
//        loginViewModel.loginResult.observe(this@LoginActivity, Observer {
//            val loginResult = it ?: return@Observer
//
//            loading.visibility = View.GONE
//            if (loginResult.error != null) {
//                showLoginFailed(loginResult.error)
//            }
//            if (loginResult.success != null) {
//                updateUiWithUser(loginResult.success)
//            }
//            setResult(Activity.RESULT_OK)
//
//            //Complete and destroy login activity once successful
////            finish()
//        })
//
//        username.afterTextChanged {
//            loginViewModel.loginDataChanged(
//                username.text.toString(),
//                password.text.toString()
//            )
//        }
//
//        password.apply {
//            afterTextChanged {
//                loginViewModel.loginDataChanged(
//                    username.text.toString(),
//                    password.text.toString()
//                )
//            }
//
////            setOnEditorActionListener { _, actionId, _ ->
////                when (actionId) {
////                    EditorInfo.IME_ACTION_DONE ->
////                        loginViewModel.login(
////                            username.text.toString(),
////                            password.text.toString()
////                        )
////                }
////                false
////            }
//
//            login.setOnClickListener {
//                loading.visibility = View.VISIBLE
//
//                auth.signInWithEmailAndPassword(
//                    username.text.toString(),password.text.toString()).addOnCompleteListener {
//                        result ->
//
//                    if(result.isSuccessful) {
//
//
//                        val intentAct: Intent = Intent(context, HomeActivity::class.java)
////                        if(user != null) {
//                        intentAct.putExtra("USER", "model");
//
////                        }
//
//                        context.startActivity(intentAct)
//                    }else {
//
//                    }
//                }
////                loginViewModel.login(username.text.toString(), password.text.toString())
//            }
//        }
//    }
//
//    private fun updateUiWithUser(model: LoggedInUserView) {
//        val welcome = getString(R.string.welcome)
//        val displayName = model.displayName
//        // TODO : initiate successful logged in experience
//
//                                val intentAct: Intent = Intent(this, HomeActivity::class.java)
////                        if(user != null) {
//                            intentAct.putExtra("USER", "model");
//
////                        }
//
//                        this.startActivity(intentAct)
////        Toast.makeText(
////            applicationContext,
////            "$welcome $displayName",
////            Toast.LENGTH_LONG
////        ).show()
//    }
//
//    private fun showLoginFailed(@StringRes errorString: Int) {
//        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
//    }
//}
//
///**
// * Extension function to simplify setting an afterTextChanged action to EditText components.
// */
//fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
//    this.addTextChangedListener(object : TextWatcher {
//        override fun afterTextChanged(editable: Editable?) {
//            afterTextChanged.invoke(editable.toString())
//        }
//
//        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
//
//        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
//    })
//}

class LoginActivity : AppCompatActivity() {

    lateinit var context: Context

    lateinit var loginViewModel: LoginViewModel

    private var auth: FirebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        context = this@LoginActivity
//        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

//        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
//        final View yourTitleView = inflater.inflate(R.layout.title, null);
        login_button.setOnClickListener {

            login_button.visibility = View.GONE
            progressBar.visibility = View.VISIBLE

            auth.signInWithEmailAndPassword(login_email_edit_text.text.toString(), login_password_edit_text.text.toString())
                .addOnCompleteListener { task ->
//
                    if (task.isSuccessful) {
//                        println("yeeeee")
                        val user = auth.currentUser

                        Log.d("ASDDAS", user?.email.toString())
                        val intentAct: Intent = Intent(context, HomeActivity::class.java)
                        if(user != null) {
                            intentAct.putExtra("USER", user);

                        }

                        context.startActivity(intentAct)
//                    success = true
//                    _success.value = true

                    } else {
                        println(task.exception)
//                errorMessage = "Hibaaa van"
//                        errorMessage.value = "Hibaa"
//                    success = false
//                    _success.value = false
                    }


                }
        }

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