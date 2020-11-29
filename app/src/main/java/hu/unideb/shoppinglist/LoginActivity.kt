package hu.unideb.shoppinglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import hu.unideb.shoppinglist.pages.HomeActivity

class LoginActivity : AppCompatActivity() {
//    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)


        setContentView(R.layout.login_layout)

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

    fun goToHome() {

    }

    fun goToHome(view: View) {
        val intentAct: Intent =Intent(this@LoginActivity, HomeActivity::class.java)
        startActivity(intentAct)
    }
}