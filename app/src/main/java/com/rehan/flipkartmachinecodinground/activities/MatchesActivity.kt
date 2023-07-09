package com.rehan.flipkartmachinecodinground.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rehan.flipkartmachinecodinground.R
import com.rehan.flipkartmachinecodinground.adapters.MatchesAdapter
import com.rehan.flipkartmachinecodinground.databinding.ActivityMatchesBinding
import com.rehan.flipkartmachinecodinground.viewmodels.MatchesViewModel

class MatchesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMatchesBinding
    private lateinit var viewModel: MatchesViewModel
    private lateinit var adapter: MatchesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_matches)

        val playerId = intent.getIntExtra(EXTRA_PLAYER_ID, -1)
        viewModel = ViewModelProvider(this, MatchesViewModel.Factory(application, playerId))[MatchesViewModel::class.java]
        adapter = MatchesAdapter()

        binding.rvStarWarsMatches.layoutManager = LinearLayoutManager(this)
        binding.rvStarWarsMatches.adapter = adapter

        viewModel.matches.observe(this) { matches ->
            // Update the UI with the filtered matches
            adapter.submitList(matches)
        }
    }

    companion object {
        const val EXTRA_PLAYER_ID = "extra_player_id"
    }
}