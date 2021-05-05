package com.example.weatherlowes.viewmodel

import androidx.lifecycle.*
import com.example.weatherlowes.remote.WeatherRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepo: WeatherRepo) : ViewModel() {

    fun getWeatherData(cityName : String) = weatherRepo.getWeatherDataFromName(cityName).asLiveData()

}
