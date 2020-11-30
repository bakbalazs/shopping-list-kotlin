package hu.unideb.shoppinglist

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import hu.unideb.shoppinglist.pages.HomeActivity

class LoginViewModel() : ViewModel() {

    private var auth: FirebaseAuth = Firebase.auth

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    var errorMessage = MutableLiveData<String>()


    fun login(view: View) {
        val context: Context = view.context;

        auth.signInWithEmailAndPassword(email.value.toString(), password.value.toString())
            .addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    println("yeeeee")
                    val intentAct: Intent = Intent(context, HomeActivity::class.java)
                    context.startActivity(intentAct)
//                    success = true
//                    _success.value = true

                } else {
                    println(task.exception)
//                errorMessage = "Hibaaa van"
                    errorMessage.value = "Hibaa"
//                    success = false
//                    _success.value = false
                }


            }
//println(login())
//        if (success.value == true) {
//
//        }

//        val live: LiveData<UserData> = repo.newUser()


//        auth.createUserWithEmailAndPassword(email.value.toString(),password.value.toString()).addOnCompleteListener {
//            task ->
//
//            if(task.isSuccessful) {
//                println("yuhuuuuu")
//            }else {
//                println("OHH NOOO")
//                println(task.exception)
//            }
//        }


    }


}