package hu.unideb.shoppinglist.registration

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import hu.unideb.shoppinglist.R
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    lateinit var context: Context
    private var auth: FirebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
//
//
//

        button3.setOnClickListener {
                    auth.createUserWithEmailAndPassword(editTextTextEmailAddress.text.toString(), editTextTextPassword.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "createUserWithEmail:success")
                    val user = auth.currentUser
//                FirebaseUser user22 = FirebaseAuth.getInstance().getCurrentUser();

//                    val profileUpdates = userProfileChangeRequest {
//                        displayName = editTextTextPersonName2.text.toString()
////                    photoUri = Uri.parse("https://example.com/jane-q-user/profile.jpg")
//                    }

//                    user!!.updateProfile(profileUpdates)
//                        .addOnCompleteListener { task ->
//                            if (task.isSuccessful) {
//                                Log.d("TAG", "User profile updated.")
//                            }
//                        }
//                user?.updateProfile({
//                        displayName: newUser.name
//                })
                    Log.w("TAG", user.toString());
//                updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "createUserWithEmail:failure", task.exception)
//                Toast.makeText(baseContext, "Authentication failed.",
//                    Toast.LENGTH_SHORT).show()
//                updateUI(null)
                }

                // ...
            }

        }
        //println(login())
//        if (success.value == true) {
//
//        }

//        val live: LiveData<UserData> = repo.newUser()




    }
}