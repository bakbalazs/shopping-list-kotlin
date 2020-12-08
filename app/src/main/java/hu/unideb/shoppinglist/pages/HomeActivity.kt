package hu.unideb.shoppinglist.pages

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseUser
import hu.unideb.shoppinglist.R

class HomeActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityHomeBinding


    private lateinit var appBarConfiguration: AppBarConfiguration

    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//
//        val binding: FragmentProductListBinding = DataBindingUtil.inflate(
//            inflater, R.layout.fragment_product_list, container, false
//        )

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)

        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_about, R.id.nav_products
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val bundle = intent.extras
//        val arr  = bundle?.getParcelable<FirebaseUser>("TEST")!!
//        navView.getHeaderView(0).findViewById<TextView>(R.id.name).text = arr.displayName.toString()
//
//        navView.getHeaderView(0).findViewById<TextView>(R.id.email).text = arr.email.toString()


//        val navHeader:LinearLayout  = findViewById(R.id.test)

//
//        navHeader.findViewById<TextView>(R.id.email).text = arr.email.toString()


//        navView.findViewById<TextView>(R.id.email).text = arr.email.toString()
//        val textView: TextView = findViewById<TextView>(R.id.email)
//        textView.text = arr.email.toString()

//        binding.email.text = arr.email.toString()

//        homeViewModel.test = arr.email.toString()
//        binding.email.text = arr.email.toString()
//        Log.d("NÉV", arr.email.toString())

//        email.text = arr.email.toString()
//        val textView: TextView = findViewById(R.id.email) as TextView
//
//        textView.text = arr.email.toString()

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}