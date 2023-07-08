package com.rehan.flipkartmachinecodinground.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rehan.flipkartmachinecodinground.R
import com.rehan.flipkartmachinecodinground.databinding.AdapterStarWarsPlayersBinding
import com.rehan.flipkartmachinecodinground.models.starwarsplayers.StarWarsPlayersItem
import com.squareup.picasso.Picasso

class StarWarsPlayersAdapter(private val playersList: List<StarWarsPlayersItem>) :
    RecyclerView.Adapter<StarWarsPlayersAdapter.ViewHolder>() {

//    private var playersList = ArrayList<StarWarsPlayersItem>()
//    var onItemClick: ((StarWarsPlayersItem) -> Unit)? = null
//
//    fun setPlayersList(playersList: List<StarWarsPlayersItem>){
//        this.playersList = playersList as ArrayList<StarWarsPlayersItem>
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterStarWarsPlayersBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val playersList = playersList[position]

        // Loading image using COIL library
        holder.binding.ivPlayer.load(playersList.icon) {
            placeholder(R.drawable.loading_image)
            error(R.drawable.loading_image)
        }

        holder.binding.tvPlayerName.text = playersList.name
        holder.binding.tvPlayerScore.text = playersList.id.toString()

        // When user clicks on item views in recyclerview
//        holder.itemView.setOnClickListener {
//            onItemClick!!.invoke(playersList[position])
//        }

    }

    override fun getItemCount(): Int {
        return playersList.size
    }

    inner class ViewHolder(val binding: AdapterStarWarsPlayersBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

}