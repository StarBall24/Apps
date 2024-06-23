package com.example.starball24.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.starball24.Data.TeamStanding
import com.example.starball24.databinding.ItemStandingsBinding

class StandingAdapter(): RecyclerView.Adapter<StandingAdapter.standingViewHolder>() {
    private var newStanding:List<TeamStanding> = emptyList()
    class standingViewHolder(private val binding: ItemStandingsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(teamStanding: TeamStanding) {
            binding.clubName.text = teamStanding.team.name
            binding.plNum.text = teamStanding.all.played.toString()
            binding.rankNum.text = teamStanding.rank.toString()
            binding.wNum.text = teamStanding.all.win.toString()
            binding.LNum.text = teamStanding.all.lose.toString()
            binding.DNum.text = teamStanding.all.draw.toString()
            Glide.with(binding.logoClub.context)
                .load(teamStanding.team.logo)
                .into(binding.logoClub)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): standingViewHolder {
        val binding = ItemStandingsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return standingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newStanding.size
    }

    override fun onBindViewHolder(holder: standingViewHolder, position: Int) {
        val getTeamStanding = newStanding[position]
        holder.bind(getTeamStanding)
    }

    fun setStandings(newStandings: List<TeamStanding>) {
        this.newStanding = newStandings
        notifyDataSetChanged()
    }
}