package com.example.weatherapp.repo

import com.example.weatherapp.repo.remote.RetrofitInstance
import com.example.weatherlowes.model.WeatherData
import com.example.weatherlowes.utils.constants.API_KEY
import retrofit2.HttpException

object WeatherRepo {
    val WeatherService = RetrofitInstance.getWeatherService
    //API key comes from the utils class object
    suspend fun getNameWeather(city: String) : WeatherData? {
        try {
            return RetrofitInstance.getWeatherService.getAllWeather(city, API_KEY, "imperial")
        } catch (ex: HttpException){
    }
        return null
    }
}