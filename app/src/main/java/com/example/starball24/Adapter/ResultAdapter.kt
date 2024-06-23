package com.example.starball24.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.starball24.Data.response
import com.example.starball24.databinding.ItemResultFixtureBinding

class ResultAdapter():RecyclerView.Adapter<ResultAdapter.resultViewHolder>() {
    private var result:List<response> = emptyList()
    class resultViewHolder(private val binding: ItemResultFixtureBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(result: response) {
            binding.nameHome.text = result.teams.home.name
            binding.nameAway.text = result.teams.away.name
            binding.timeView.text = result.fixture.date.substring(11,16)
            binding.scoreHome.text = result.goals.home.toString()
            binding.scoreAway.text = result.goals.away.toString()
            Glide.with(binding.homeImage.context)
                .load(result.teams.home.logo)
                .into(binding.homeImage)
            Glide.with(binding.awayImage.context)
                .load(result.teams.away.logo)
                .into(binding.awayImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): resultViewHolder {
        val binding = ItemResultFixtureBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return resultViewHolder(binding)
    }

    override fun getItemCount(): Int = result.size
    override fun onBindViewHolder(holder: resultViewHolder, position: Int) {
        val result = result[position]
        holder.bind(result)
    }
    fun setResult(result: List<response>) {
        this.result = result
        notifyDataSetChanged()
    }
}