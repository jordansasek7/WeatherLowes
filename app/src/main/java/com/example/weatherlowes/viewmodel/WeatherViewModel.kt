package com.example.weatherlowes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherlowes.repo.WeatherRepo
import com.example.weatherlowes.model.WeatherData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _weather = MutableLiveData<WeatherData?>()
    val weather: LiveData<WeatherData?> get() = _weather

    var city: String = ""
        set(value) {
            viewModelScope.launch(Dispatchers.IO) {
                _weather.postValue(WeatherRepo.getNameWeather(value))
            }
            field = value
        }
}
