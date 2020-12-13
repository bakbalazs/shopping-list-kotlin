package hu.unideb.shoppinglist.pages.activities.registration

import android.content.Context
import android.os.Bundle
import android.widget.Toast
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
            if (registration_email_edit_text.text.toString()
                    .isEmpty() || registration_password_edit_text.text.toString()
                    .isEmpty() || registration_personal_name_edit_text.text.toString().isEmpty()
            ) {
                errorText.text = getString(R.string.register_error_all_field)
            } else {

                if (!registration_email_edit_text.text.toString().contains("@")) {
                    errorText.text = getString(R.string.reg_and_login_error_email_format)
                } else {
                    auth.createUserWithEmailAndPassword(
                        registration_email_edit_text.text.toString(),
                        registration_password_edit_text.text.toString()
                    )
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                val user = auth.currentUser

                                val profileUpdates = userProfileChangeRequest {
                                    displayName =
                                        registration_personal_name_edit_text.text.toString()
                                }

                                user!!.updateProfile(profileUpdates)
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            Toast.makeText(
                                                context,
                                                getText(R.string.registration_success),
                                                Toast.LENGTH_LONG
                                            ).show()
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
    }
}