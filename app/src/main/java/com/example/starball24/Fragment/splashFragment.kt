package com.example.starball24.Fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.starball24.R
import com.example.starball24.databinding.FragmentSplashBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class splashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.navigationBar)
        bottomNav?.visibility = View.INVISIBLE
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        Handler(Looper.myLooper()!!).postDelayed(
            {
                navController.navigate(R.id.action_splashFragment_to_homeFragment)
            }
        ,3000)
    }

}