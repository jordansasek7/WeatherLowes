package com.example.weatherlowes.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter =true)
data class WeatherData(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<AllData>,
    val message: Int
)