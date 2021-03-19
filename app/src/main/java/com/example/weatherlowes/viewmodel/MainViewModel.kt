package com.example.weatherlowes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.repo.WeatherRepo
import com.example.weatherlowes.model.WeatherData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


    class MainViewModel : ViewModel() {
        private val _weather = MutableLiveData<WeatherData>()
        val weather: LiveData<WeatherData> get() = _weather


       fun getWeather(city: String) {
            //use coroutine(launch to send network call for the city being passed from the et on  first page
            viewModelScope.launch(Dispatchers.IO) {
                val weatherResponse = WeatherRepo.getNameWeather(city)
                _weather.postValue(weatherResponse!!)
            }
        }
        }
