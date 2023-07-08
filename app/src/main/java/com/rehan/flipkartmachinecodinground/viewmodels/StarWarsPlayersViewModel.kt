//package com.rehan.flipkartmachinecodinground.viewmodels
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.rehan.flipkartmachinecodinground.repositories.StarWarsPlayersRepository
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class StarWarsPlayersViewModel @Inject constructor(private val starWarsPlayersRepository: StarWarsPlayersRepository) : ViewModel() {
//
//    val playersLiveData get() = starWarsPlayersRepository.playersListResponseLiveData
//
//    fun getPlayersList() {
//        viewModelScope.launch {
//            starWarsPlayersRepository.getPlayersList()
//        }
//    }
//}