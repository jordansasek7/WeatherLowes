package com.example.weatherlowes.repo

import com.example.weatherapp.repo.remote.RetrofitInstance
import retrofit2.HttpException

object WeatherRepo {

    suspend fun getNameWeather(city: String) = try {
        RetrofitInstance.getWeatherService.getAllWeather(city)
    } catch (ex: HttpException) {
        null
    }

}