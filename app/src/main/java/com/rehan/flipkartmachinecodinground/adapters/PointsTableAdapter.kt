package com.rehan.flipkartmachinecodinground.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rehan.flipkartmachinecodinground.databinding.ItemPlayerBinding
import com.rehan.flipkartmachinecodinground.models.Player

class PointsTableAdapter(private val listener: OnPlayerClickListener) :
    ListAdapter<Player, PointsTableAdapter.PointsTableViewHolder>(PointsTableDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointsTableViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPlayerBinding.inflate(inflater, parent, false)
        return PointsTableViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PointsTableViewHolder, position: Int) {
        val player = getItem(position)
        holder.bind(player)
    }

    inner class PointsTableViewHolder(private val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(player: Player) {
            binding.tvPlayerName.text = player.name
            binding.tvPlayerScore.text = player.score.toString()
            binding.tvPlayerScore.text = player.totalScore.toString()

            Glide.with(binding.root)
                .load(player.icon)
                .into(binding.ivPlayer)
        }

        override fun onClick(v: View) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val player = getItem(position)
                listener.onPlayerClick(player.id)
            }
        }
    }

    class PointsTableDiffCallback : DiffUtil.ItemCallback<Player>() {
        override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
            return oldItem == newItem
        }
    }

    interface OnPlayerClickListener {
        fun onPlayerClick(playerId: Int)
    }
}
