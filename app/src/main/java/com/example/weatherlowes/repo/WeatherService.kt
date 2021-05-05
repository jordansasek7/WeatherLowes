package com.example.weatherlowes.repo


import com.example.weatherlowes.model.WeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("forecast")
    suspend fun getAllWeather(
        @Query("q") city: String,
        @Query("appid") appid: String = "48ee756b54ad7853a0970de51f241482",
        @Query("units") units: String = "imperial"
    ): Response<WeatherData>
}