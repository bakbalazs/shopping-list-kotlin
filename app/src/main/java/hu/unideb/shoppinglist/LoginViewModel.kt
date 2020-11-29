package hu.unideb.shoppinglist

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import hu.unideb.shoppinglist.pages.HomeActivity

class LoginViewModel:ViewModel() {

    fun goToHomePage(context: Context) {
            val intentAct: Intent =Intent(context, HomeActivity::class.java)
            context.startActivity(intentAct)
    }
}