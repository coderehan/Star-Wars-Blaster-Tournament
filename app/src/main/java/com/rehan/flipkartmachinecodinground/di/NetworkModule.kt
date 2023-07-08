//package com.rehan.flipkartmachinecodinground.di
//
//import com.rehan.flipkartmachinecodinground.api.StarWarsAPI
//import com.rehan.flipkartmachinecodinground.repositories.StarWarsMatchesRepository
//import com.rehan.flipkartmachinecodinground.repositories.StarWarsPlayersRepository
//import com.rehan.flipkartmachinecodinground.utils.Constants
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Singleton
//
//@InstallIn(SingletonComponent::class)
//@Module
//class NetworkModule {
//
//    @Singleton
//    @Provides
//    fun providesRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(Constants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun providesStarWarsAPI(retrofit: Retrofit): StarWarsAPI {
//        return retrofit.create(StarWarsAPI::class.java)
//    }
//
//    @Singleton
//    @Provides
//    fun providesStarWarsPlayersRepository(starWarsAPI: StarWarsAPI): StarWarsPlayersRepository {
//        return StarWarsPlayersRepository(starWarsAPI)
//    }
//
//    @Singleton
//    @Provides
//    fun providesStarWarsMatchesRepository(starWarsAPI: StarWarsAPI): StarWarsMatchesRepository {
//        return StarWarsMatchesRepository(starWarsAPI)
//    }
//}