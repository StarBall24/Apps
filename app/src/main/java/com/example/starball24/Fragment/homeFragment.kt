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
import com.example.starball24.Adapter.MatchesAdapter
import com.example.starball24.Data.RequestBody
import com.example.starball24.Data.response
import com.example.starball24.R
import com.example.starball24.ViewModel.MatchesViewModel
import com.example.starball24.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class homeFragment : Fragment(),MatchesAdapter.OnButtonClicked {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: MatchesViewModel
    private lateinit var adapter: MatchesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val navBottom = activity?.findViewById<BottomNavigationView>(R.id.navigationBar)
        navBottom?.visibility = View.VISIBLE
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MatchesAdapter(this)
        viewModel = ViewModelProvider(this).get(MatchesViewModel::class.java)
        binding.homeRv.layoutManager = LinearLayoutManager(context)
        binding.homeRv.adapter = adapter
        viewModel.matches.observe(viewLifecycleOwner, Observer {
            adapter.setMatches(it)
        })
        viewModel.predict.observe(viewLifecycleOwner, Observer {
            adapter.setPredict(it)
        })
        viewModel.feacthMatches()
    }

    override fun onButtonClicked(data: response) {
        viewModel.apply {
            val getHome = data.teams.home.name.lowercase()
            val getAway = data.teams.away.name.lowercase()
            val getDate = data.fixture.date
            val hour = getDate.substring(11,13).toInt()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")
            val day = LocalDateTime.parse(getDate, formatter)
            val getDay = day.dayOfWeek.toString()
            Log.d("HomeFragment", "onButtonClick called with data: HomeTeam: $getHome, AwayTeam: $getAway, Hour: $hour, DayCode: $getDay")
            val requestBody = RequestBody(getHome,getAway,hour,getDay)
            viewModel.predictMatch(requestBody)
        }
    }


}