package hu.unideb.shoppinglist

import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import hu.unideb.shoppinglist.pages.HomeActivity

class LoginViewModel():ViewModel() {

    fun goToHomePage(view: View) {
                val context:Context = view.context;
            val intentAct: Intent =Intent(context, HomeActivity::class.java)
            context.startActivity(intentAct)
    }
}