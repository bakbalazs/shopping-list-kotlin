package hu.unideb.shoppinglist.pages.activities.registration

import android.content.Context
import android.os.Bundle
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

        register_button.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                registration_email_edit_text.text.toString(),
                registration_password_edit_text.text.toString()
            )
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser

                        val profileUpdates = userProfileChangeRequest {
                            displayName = registration_personal_name_edit_text.text.toString()
                        }

                        user!!.updateProfile(profileUpdates)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    super.onBackPressed();
                                }
                            }

                    } else {
                        errorText.text = task.exception.toString()

                    }

                }

        }
    }
}