package com.rehan.flipkartmachinecodinground.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rehan.flipkartmachinecodinground.adapters.StarWarsPlayersAdapter
import com.rehan.flipkartmachinecodinground.databinding.FragmentStarWarsPlayersBinding
import com.rehan.flipkartmachinecodinground.models.starwarsplayers.StarWarsPlayersItem
import java.io.IOException
import java.io.InputStream

class StarWarsPlayersFragment : Fragment() {

    private var _binding: FragmentStarWarsPlayersBinding? = null
    private val binding get() = _binding!!
    private lateinit var playersAdapter: StarWarsPlayersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStarWarsPlayersBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Function to read the JSON file from the asset folder
        fun loadJSONFromAsset(context: Context, fileName: String): String? {
            var json: String? = null
            try {
                val inputStream: InputStream = context.assets.open(fileName)
                val size: Int = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, Charsets.UTF_8)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return json
        }

        // Load JSON data and parse it into a list of items
        val json: String? = loadJSONFromAsset(requireContext(), "star_wars_players.json")
        val playersList: List<StarWarsPlayersItem> =
            Gson().fromJson(json, object : TypeToken<List<StarWarsPlayersItem>>() {}.type)

        playersAdapter = StarWarsPlayersAdapter(playersList)
        binding.rvStarWarsPlayers.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = playersAdapter
        }
    }
}