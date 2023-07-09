package com.rehan.flipkartmachinecodinground.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rehan.flipkartmachinecodinground.R
import com.rehan.flipkartmachinecodinground.activities.MatchesActivity.Companion.EXTRA_PLAYER_ID
import com.rehan.flipkartmachinecodinground.adapters.PointsTableAdapter
import com.rehan.flipkartmachinecodinground.databinding.ActivityPointsTableBinding
import com.rehan.flipkartmachinecodinground.viewmodels.PointsTableViewModel

class PointsTableActivity : AppCompatActivity(), PointsTableAdapter.OnPlayerClickListener {
    private lateinit var viewModel: PointsTableViewModel
    private lateinit var adapter: PointsTableAdapter
    private lateinit var binding: ActivityPointsTableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_points_table)

        // Initialize the ViewModel
        viewModel = ViewModelProvider(this)[PointsTableViewModel::class.java]

        // Set up RecyclerView
        adapter = PointsTableAdapter(this)
        binding.rvStarWarsPlayers.layoutManager = LinearLayoutManager(this)
        binding.rvStarWarsPlayers.adapter = adapter

        // Observe the points table data
        viewModel.getPointsTableLiveData().observe(this, Observer { players ->
            // Update the adapter with the new data
            adapter.submitList(players)
        })
    }

    override fun onPlayerClick(playerId: Int) {
        val intent = Intent(this, MatchesActivity::class.java)
        intent.putExtra(EXTRA_PLAYER_ID, playerId)
        startActivity(intent)
    }
}
