package com.example.starball24.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starball24.Adapter.StandingAdapter
import com.example.starball24.ApiServices.RetrofitService
import com.example.starball24.Data.League
import com.example.starball24.Data.ResponseStanding
import com.example.starball24.Data.TeamStanding
import com.example.starball24.R
import com.example.starball24.ViewModel.MatchesViewModel
import com.example.starball24.databinding.FragmentStandingBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class standingFragment : Fragment() {
    private lateinit var binding: FragmentStandingBinding
    private lateinit var adapter: StandingAdapter
    private lateinit var viewModel: MatchesViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val navBottom = activity?.findViewById<BottomNavigationView>(R.id.navigationBar)
        navBottom?.visibility = View.VISIBLE
        binding = FragmentStandingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = StandingAdapter()
        viewModel = ViewModelProvider(this).get(MatchesViewModel::class.java)
        binding.standingList.layoutManager = LinearLayoutManager(requireContext())
        binding.standingList.adapter = adapter
        viewModel.standing.observe(viewLifecycleOwner, Observer {
            adapter.setStandings(it)
        })
        viewModel.feacthStanding()
    }

}