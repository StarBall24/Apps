package com.example.starball24.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.starball24.Data.ResponsePredict
import com.example.starball24.Data.response
import com.example.starball24.databinding.FixturesStandingItemBinding

class MatchesAdapter(private val onButtonClicked:OnButtonClicked): RecyclerView.Adapter<MatchesAdapter.MatchesListViewHolder>() {
    private var fixtures: List<response> = emptyList()
    private var responsePredict: ResponsePredict = ResponsePredict("")
    inner class MatchesListViewHolder(val binding: FixturesStandingItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: response) {
            binding.nameHome.text = data.teams.home.name
            binding.nameAway.text = data.teams.away.name
            Glide.with(binding.homeImage.context)
                .load(data.teams.home.logo)
                .into(binding.homeImage)
            Glide.with(binding.awayImage.context)
                .load(data.teams.away.logo)
                .into(binding.awayImage)
            binding.btnPredict.setOnClickListener {
                onButtonClicked.onButtonClicked(data)
                binding.textPrediction.text = responsePredict.predicted_outcome
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesListViewHolder {
        val binding = FixturesStandingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchesListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return fixtures.size
    }
    fun setMatches(fixtures: List<response>) {
        this.fixtures = fixtures
        notifyDataSetChanged()
    }
    fun setPredict(predict:ResponsePredict){
        this.responsePredict = predict
    }

    override fun onBindViewHolder(holder: MatchesListViewHolder, position: Int) {
        val getData = fixtures[position]
        holder.bind(getData)

    }

    interface OnButtonClicked {
        fun onButtonClicked(data: response)
    }
}