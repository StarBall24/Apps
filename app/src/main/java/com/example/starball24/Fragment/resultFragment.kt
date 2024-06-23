package com.example.starball24.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starball24.Adapter.ResultAdapter
import com.example.starball24.R
import com.example.starball24.ViewModel.MatchesViewModel
import com.example.starball24.databinding.FragmentResultBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class resultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private lateinit var adapter: ResultAdapter
    private lateinit var viewModel:MatchesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val nav_bottom = activity?.findViewById<BottomNavigationView>(R.id.navigationBar)
        nav_bottom?.visibility = View.VISIBLE
        binding= FragmentResultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ResultAdapter()
        viewModel = ViewModelProvider(this).get(MatchesViewModel::class.java)
        binding.resultRv.layoutManager = LinearLayoutManager(requireContext())
        binding.resultRv.adapter = adapter
        viewModel.result.observe(viewLifecycleOwner, Observer {
            adapter.setResult(it)
        })
        viewModel.feacthResult()
    }

}