package com.example.weatherlowes.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Wind(
    @Json(name = "deg")val degrees: Int,
    val speed: Double
) : Parcelable