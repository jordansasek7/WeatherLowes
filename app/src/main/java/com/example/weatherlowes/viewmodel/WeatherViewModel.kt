package com.example.weatherlowes.viewmodel

import androidx.lifecycle.*
import com.example.weatherlowes.repo.WeatherRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepo: WeatherRepo) : ViewModel() {

    fun getWeatherData(cityName : String) = weatherRepo.getNameWeather(cityName).asLiveData()

}
