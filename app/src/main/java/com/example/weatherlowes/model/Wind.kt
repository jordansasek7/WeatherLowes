package com.example.weatherlowes.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter =true)
data class Wind(
    val deg: Int,
    val speed: Double
)  : Parcelable {}