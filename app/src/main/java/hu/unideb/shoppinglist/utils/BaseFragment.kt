package hu.unideb.shoppinglist.utils

import android.content.Context
import androidx.fragment.app.Fragment
import hu.unideb.shoppinglist.pages.activities.home.HomeActivity

abstract class BaseFragment : Fragment() {

    lateinit var ACTIVITY: HomeActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ACTIVITY = context as HomeActivity
    }
}