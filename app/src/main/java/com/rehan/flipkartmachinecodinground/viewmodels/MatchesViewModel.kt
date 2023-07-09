package com.rehan.flipkartmachinecodinground.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rehan.flipkartmachinecodinground.models.Match
import com.rehan.flipkartmachinecodinground.repositories.MatchesRepository

class MatchesViewModel(application: Application, private val playerId: Int) : AndroidViewModel(application) {
    private val repository: MatchesRepository = MatchesRepository(application)
    private val matchesLiveData: LiveData<List<Match>> = repository.getMatchesLiveData()

    init {
        repository.filterMatchesByPlayerId(playerId)
    }

    val matches: LiveData<List<Match>>
        get() = matchesLiveData

    class Factory(private val application: Application, private val playerId: Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MatchesViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MatchesViewModel(application, playerId) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
