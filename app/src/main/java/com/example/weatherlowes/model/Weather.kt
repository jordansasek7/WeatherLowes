package com.example.weatherlowes.model

import android.os.Parcelable
import androidx.lifecycle.GeneratedAdapter
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter =true)
data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)  : Parcelable {}