package com.rehan.flipkartmachinecodinground.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rehan.flipkartmachinecodinground.models.Match
import com.rehan.flipkartmachinecodinground.models.Player
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class PointsTableRepository(application: Application) {
    private val playersLiveData: MutableLiveData<List<Player>> = MutableLiveData()

    init {
        loadPointsTableFromJson(application)
    }

    private fun loadPointsTableFromJson(application: Application) {
        val playersJson = readJsonFromAssets(application, "star_wars_players.json")
        val matchesJson = readJsonFromAssets(application, "star_wars_matches.json")

        val players = parsePlayersFromJson(playersJson)
        val matches = parseMatchesFromJson(matchesJson)

        val pointsTable = calculatePointsTable(players, matches)
        playersLiveData.value = pointsTable
    }

    fun getPointsTableLiveData(): LiveData<List<Player>> {
        return playersLiveData
    }

    private fun readJsonFromAssets(application: Application, fileName: String): String {
        return application.assets.open(fileName).bufferedReader().use { it.readText() }
    }

    private fun parsePlayersFromJson(json: String): List<Player> {
        return try {
            val jsonArray = JSONArray(json)
            val players = mutableListOf<Player>()

            for (i in 0 until jsonArray.length()) {
                val playerJson = jsonArray.getJSONObject(i)
                val id = playerJson.getInt("id")
                val name = playerJson.getString("name")
                val icon = playerJson.getString("icon")
                val player = Player(id, name, icon)
                players.add(player)
            }

            players
        } catch (e: JSONException) {
            e.printStackTrace()
            emptyList()
        }
    }

    private fun parseMatchesFromJson(json: String): List<Match> {
        return try {
            val jsonArray = JSONArray(json)
            val matches = mutableListOf<Match>()

            for (i in 0 until jsonArray.length()) {
                val matchJson = jsonArray.getJSONObject(i)
                val match = Match(
                    matchJson.getInt("match"),
                    parsePlayerFromJson(matchJson.getJSONObject("player1")),
                    parsePlayerFromJson(matchJson.getJSONObject("player2"))
                )
                matches.add(match)
            }

            matches
        } catch (e: JSONException) {
            e.printStackTrace()
            emptyList()
        }
    }

    private fun parsePlayerFromJson(playerJson: JSONObject): Player {
        val id = playerJson.getInt("id")
        val score = playerJson.getInt("score")
        return Player(id, "", "", score)
    }

    private fun calculatePointsTable(players: List<Player>, matches: List<Match>): List<Player> {
        val pointsMap = mutableMapOf<Int, Int>()
        val totalScoresMap = mutableMapOf<Int, Int>()

        // Initialize points and total scores for each player
        for (player in players) {
            pointsMap[player.id] = 0
            totalScoresMap[player.id] = 0
        }

        // Calculate points and total scores based on matches
        for (match in matches) {
            val player1 = match.player1
            val player2 = match.player2
            val score1 = player1.score
            val score2 = player2.score

            if (score1 > score2) {
                // Player 1 wins
                pointsMap[player1.id] = pointsMap[player1.id]!! + 3
            } else if (score1 < score2) {
                // Player 2 wins
                pointsMap[player2.id] = pointsMap[player2.id]!! + 3
            } else {
                // Draw
                pointsMap[player1.id] = pointsMap[player1.id]!! + 1
                pointsMap[player2.id] = pointsMap[player2.id]!! + 1
            }

            totalScoresMap[player1.id] = totalScoresMap[player1.id]!! + score1
            totalScoresMap[player2.id] = totalScoresMap[player2.id]!! + score2
        }

        // Create a list of players with points and total scores
        val playersWithPoints = mutableListOf<Player>()
        for (player in players) {
            val points = pointsMap[player.id] ?: 0
            val totalScore = totalScoresMap[player.id] ?: 0
            val playerWithPoints = Player(player.id, player.name, player.icon, player.score, totalScore)
            playersWithPoints.add(playerWithPoints)
        }

        // Sort the players based on points and total scores
        val sortedPlayers = playersWithPoints.sortedWith(
            compareByDescending<Player> { it.score }
                .thenByDescending { it.totalScore }
        )

        return sortedPlayers
    }
}
