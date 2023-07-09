package com.rehan.flipkartmachinecodinground.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.rehan.flipkartmachinecodinground.models.Player
import com.rehan.flipkartmachinecodinground.repositories.PointsTableRepository

class PointsTableViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PointsTableRepository = PointsTableRepository(application)
    private val pointsTableLiveData: LiveData<List<Player>> = repository.getPointsTableLiveData()

    fun getPointsTableLiveData(): LiveData<List<Player>> {
        return pointsTableLiveData
    }
}
