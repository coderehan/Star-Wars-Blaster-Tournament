package com.rehan.flipkartmachinecodinground.repositories

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken
import com.rehan.flipkartmachinecodinground.models.Match
import java.io.IOException
import java.io.InputStream

class MatchesRepository(private val application: Application) {
    private val matchesLiveData: MutableLiveData<List<Match>> = MutableLiveData()
    private val allMatches: List<Match>

    init {
        allMatches = loadMatchesFromJson()
        matchesLiveData.value = allMatches
    }

    fun getMatchesLiveData(): LiveData<List<Match>> {
        return matchesLiveData
    }

    fun filterMatchesByPlayerId(playerId: Int) {
        val filteredMatches = allMatches.filter { it.player1.id == playerId || it.player2.id == playerId }
        matchesLiveData.value = filteredMatches
    }

    private fun loadMatchesFromJson(): List<Match> {
        val jsonString = loadJsonFromAsset(application, "star_wars_matches.json")
        return parseMatchesJson(jsonString)
    }

    private fun loadJsonFromAsset(context: Context, fileName: String): String? {
        return try {
            val inputStream: InputStream = context.assets.open(fileName)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    private fun parseMatchesJson(jsonString: String?): List<Match> {
        return try {
            val gson = Gson()
            val matchType = object : TypeToken<List<Match>>() {}.type
            gson.fromJson(jsonString, matchType)
        } catch (e: JsonParseException) {
            e.printStackTrace()
            emptyList()
        }
    }
}