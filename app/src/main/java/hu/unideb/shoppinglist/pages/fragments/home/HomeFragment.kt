package hu.unideb.shoppinglist.pages.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import hu.unideb.shoppinglist.R
import hu.unideb.shoppinglist.database.AppDatabase
import hu.unideb.shoppinglist.databinding.FragmentHomeBinding
import hu.unideb.shoppinglist.utils.BaseFragment

class HomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val userId = ACTIVITY.userId

        val userEmail = ACTIVITY.userEmail

        val application = requireNotNull(this.activity).application

        val dataSource = AppDatabase.getInstance(application).productDatabaseDao

        val viewModelFactory = HomeViewModelFactory(dataSource, userId, userEmail)

        val homeFragmentViewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(HomeViewModel::class.java)

        binding.homeFragmentViewModel = homeFragmentViewModel

        binding.lifecycleOwner = this

        return binding.root
    }
}