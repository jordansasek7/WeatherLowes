package com.example.weatherlowes.repo

import com.example.weatherlowes.util.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepo @Inject constructor(private val weatherService: WeatherService) {

    fun getNameWeather(city: String) = flow {
        emit(Resource.Loading)
        val resource = if (city.isEmpty()) {
            Resource.Error("Enter a city Name")
        } else {
            val weatherData = weatherService.getAllWeather(city)
            if (weatherData.isSuccessful) {
                val results = weatherData.body()
                if (results != null) Resource.Success(results) else Resource.Error("No results found")
            } else {
                Resource.Error("An error has occurred on our end.")
            }
        }
        emit(resource)
    }
}