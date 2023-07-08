//package com.rehan.flipkartmachinecodinground.api
//
//import com.rehan.flipkartmachinecodinground.models.starwarsmatches.StarWarsMatchesResponse
//import com.rehan.flipkartmachinecodinground.models.starwarsplayers.StarWarsPlayersResponse
//import retrofit2.Response
//import retrofit2.http.GET
//
//interface StarWarsAPI {
//
//    @GET("/StarWarsPlayers")
//    suspend fun getStarWarsPlayers(): Response<StarWarsPlayersResponse>
//
//    @GET("/StarWarsMatches")
//    suspend fun getStarWarsMatches(): Response<StarWarsMatchesResponse>
//}