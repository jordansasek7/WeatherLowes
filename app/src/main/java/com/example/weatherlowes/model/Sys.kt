package com.example.weatherlowes.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter =true)
data class Sys(
    val pod: String
)  : Parcelable