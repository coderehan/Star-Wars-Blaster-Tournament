//package com.rehan.flipkartmachinecodinground.repositories
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.rehan.flipkartmachinecodinground.api.StarWarsAPI
//import com.rehan.flipkartmachinecodinground.models.starwarsmatches.StarWarsMatchesItem
//import com.rehan.flipkartmachinecodinground.models.starwarsplayers.StarWarsPlayersItem
//import com.rehan.flipkartmachinecodinground.utils.NetworkResult
//import org.json.JSONObject
//import javax.inject.Inject
//
//class StarWarsMatchesRepository @Inject constructor(private val starWarsAPI: StarWarsAPI) {
//
//    private val _matchesListResponseMutableLiveData = MutableLiveData<NetworkResult<List<StarWarsMatchesItem>>>()
//    val matchesListResponseLiveData: LiveData<NetworkResult<List<StarWarsMatchesItem>>>
//        get() = _matchesListResponseMutableLiveData
//
//    suspend fun getMatchesList() {
//        _matchesListResponseMutableLiveData.postValue(NetworkResult.Loading())
//        val response = starWarsAPI.getStarWarsMatches()
//
//        if (response.isSuccessful && response.body() != null) {
//            _matchesListResponseMutableLiveData.postValue(NetworkResult.Success(response.body()!!))
//        } else if (response.errorBody() != null) {
//            val errorObject = JSONObject(response.errorBody()!!.charStream().readText())
//            _matchesListResponseMutableLiveData.postValue(NetworkResult.Error(errorObject.getString("message")))
//        } else {
//            _matchesListResponseMutableLiveData.postValue(NetworkResult.Error("Something went wrong"))
//        }
//    }
//}