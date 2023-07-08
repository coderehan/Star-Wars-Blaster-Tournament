//package com.rehan.flipkartmachinecodinground.repositories
//
//import android.util.Log
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.rehan.flipkartmachinecodinground.api.StarWarsAPI
//import com.rehan.flipkartmachinecodinground.models.starwarsplayers.StarWarsPlayersResponse
//import com.rehan.flipkartmachinecodinground.utils.NetworkResult
//import org.json.JSONObject
//import javax.inject.Inject
//
//class StarWarsPlayersRepository @Inject constructor(private val starWarsAPI: StarWarsAPI) {
//
//    private val _playersListResponseMutableLiveData = MutableLiveData<NetworkResult<StarWarsPlayersResponse>>()
//    val playersListResponseLiveData: LiveData<NetworkResult<StarWarsPlayersResponse>>
//        get() = _playersListResponseMutableLiveData
//
//    suspend fun getPlayersList() {
//        _playersListResponseMutableLiveData.postValue(NetworkResult.Loading())
//        val response = starWarsAPI.getStarWarsPlayers()
//
//        if (response.isSuccessful && response.body() != null) {
//            Log.d("PlayersAPI", response.message())               // This is how we check if API is successful or not. It will show the http status code.
//            _playersListResponseMutableLiveData.postValue(NetworkResult.Success(response.body()!!))
//        } else {
//            _playersListResponseMutableLiveData.postValue(NetworkResult.Error("Something went wrong"))
//        }
//    }
//}