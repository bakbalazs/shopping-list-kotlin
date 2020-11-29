package hu.unideb.shoppinglist

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import hu.unideb.shoppinglist.databinding.ActivityLoginBinding
import hu.unideb.shoppinglist.pages.HomeActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel1: LoginViewModel

// ...
// Initialize Firebase Auth

//    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//    val loginModel:LoginViewModel by viewModels()

    binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
//    binding.viewModel = loginModel;


    viewModel1 = ViewModelProvider(this@LoginActivity).get(LoginViewModel::class.java)

    binding.viewModel = viewModel1

//    binding.setLifecycleOwner(this)

//                 auth = Firebase.auth

//    auth.createUserWithEmailAndPassword("bak.1@gmail.com", "test1111A")
//        .addOnCompleteListener(this) { task ->
//            if (task.isSuccessful) {
//                // Sign in success, update UI with the signed-in user's information
//                Log.d("TAG", "createUserWithEmail:success")
//                val user = auth.currentUser
////                FirebaseUser user22 = FirebaseAuth.getInstance().getCurrentUser();
//
//                val profileUpdates = userProfileChangeRequest {
//                    displayName = "Jane Q. User"
////                    photoUri = Uri.parse("https://example.com/jane-q-user/profile.jpg")
//                }
//
//                user!!.updateProfile(profileUpdates)
//                    .addOnCompleteListener { task ->
//                        if (task.isSuccessful) {
//                            Log.d("TAG", "User profile updated.")
//                        }
//                    }
////                user?.updateProfile({
////                        displayName: newUser.name
////                })
//                Log.w("TAG", user.toString());
////                updateUI(user)
//            } else {
//                // If sign in fails, display a message to the user.
//                Log.w("TAG", "createUserWithEmail:failure", task.exception)
////                Toast.makeText(baseContext, "Authentication failed.",
////                    Toast.LENGTH_SHORT).show()
////                updateUI(null)
//            }
//
//            // ...
//        }


//    auth.signInWithEmailAndPassword("bak.1@gmail.com", "test1111A")
//        .addOnCompleteListener(this) { task ->
//            if (task.isSuccessful) {
//                // Sign in success, update UI with the signed-in user's information
//                Log.d("TAG", "signInWithEmail:success")
//                val user = auth.currentUser
//                println(user?.displayName)
//                println(user?.email)
//
////                updateUI(user)
//            } else {
//                // If sign in fails, display a message to the user.
//                Log.w("TAG", "signInWithEmail:failure", task.exception)
////                Toast.makeText(baseContext, "Authentication failed.",
////                    Toast.LENGTH_SHORT).show()
////                updateUI(null)
//                // ...
//            }
//
//            // ...
//        }

//        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)


//        setContentView(R.layout.activity_login)

//        val button = findViewById<Button>(R.id.button2)
//        button.setOnClickListener {
//            val intentAct: Intent = Intent(this@LoginActivity, HomeActivity::class.java)
//            startActivity(intentAct)
//
//        }
//        button.setOnClickListener{
//            val intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
//        }
   
    }

//    fun goToHome() {
//
//    }
//
//    fun goToHome(view: View) {
//        val intentAct: Intent =Intent(this@LoginActivity, HomeActivity::class.java)
//        startActivity(intentAct)
//    }
}