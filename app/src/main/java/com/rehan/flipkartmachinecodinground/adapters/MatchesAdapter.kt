package com.rehan.flipkartmachinecodinground.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rehan.flipkartmachinecodinground.databinding.ItemMatchBinding
import com.rehan.flipkartmachinecodinground.models.Match

class MatchesAdapter : ListAdapter<Match, MatchesAdapter.MatchViewHolder>(MatchDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMatchBinding.inflate(inflater, parent, false)
        return MatchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val match = getItem(position)
        holder.bind(match)
    }

    inner class MatchViewHolder(private val binding: ItemMatchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(match: Match) {
            val player1 = match.player1
            val player2 = match.player2

            binding.tvPlayer1Score.text = player1.score.toString()
            binding.tvPlayer2Score.text = player2.score.toString()

            // Set result colors based on match outcome
            if (player1.score > player2.score) {
                binding.tvPlayer1Score.setTextColor(Color.GREEN)
                binding.tvPlayer2Score.setTextColor(Color.RED)
            } else if (player1.score < player2.score) {
                binding.tvPlayer1Score.setTextColor(Color.RED)
                binding.tvPlayer2Score.setTextColor(Color.GREEN)
            } else {
                binding.tvPlayer1Score.setTextColor(Color.BLACK)
                binding.tvPlayer2Score.setTextColor(Color.BLACK)
            }
        }
    }

    class MatchDiffCallback : DiffUtil.ItemCallback<Match>() {
        override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem.matchId == newItem.matchId
        }

        override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem == newItem
        }
    }
}
