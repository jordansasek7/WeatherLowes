package com.example.weatherapp.repo.remote


import com.example.weatherlowes.model.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    //Get the appID from the Utils folder
    //Get the path and key words for the query from the API Webpage
    @GET("forecast")
    suspend fun getAllWeather(
            @Query("q") city: String , @Query("appid") appid: String, @Query("units") units: String
    ): WeatherData
}