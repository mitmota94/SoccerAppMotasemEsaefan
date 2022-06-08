package com.example.soccerappmotasemesaefan.view

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soccerappmotasemesaefan.R
import com.example.soccerappmotasemesaefan.databinding.SoccerListItemBinding
import com.example.soccerappmotasemesaefan.model.SoccerMatch

class SoccerAdapter (private val soccerList: MutableList<SoccerMatch> = mutableListOf(),
    private val openMatchView : (SoccerMatch) -> Unit,
    private val openCompetitionUrl : (SoccerMatch) -> Unit
                     ):
    RecyclerView.Adapter<SoccerAdapter.SoccerViewHolder>(){
    fun setSoccerList(newList: List<SoccerMatch>){
        soccerList.clear()
        soccerList.addAll(newList)
        notifyDataSetChanged()
    }
    inner class SoccerViewHolder(private val binding: SoccerListItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(soccerMatch: SoccerMatch){
            Glide.with(binding.ivMatch)
                .load(soccerMatch.thumbnail)
                .fallback(R.drawable.soccer_button_1)
                .error(R.drawable.soccer_home_2)
                .into(binding.ivMatch)
            binding.tvTitle.text = soccerMatch.title.toString()
            binding.tvDate.text = soccerMatch.date.substring(0,11)
            binding.tvCompetition.text = soccerMatch.competition.toString()
            binding.ibMatchView.setOnClickListener {
            openMatchView(soccerMatch)
            }
            binding.ibCompetitionUrl.setOnClickListener {
                openCompetitionUrl(soccerMatch)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SoccerViewHolder(
        SoccerListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: SoccerViewHolder, position: Int) {
        holder.onBind(soccerList[position])
    }

    override fun getItemCount() = soccerList.size

}