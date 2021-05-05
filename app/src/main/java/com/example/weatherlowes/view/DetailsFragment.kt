package com.example.weatherlowes.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.weatherlowes.R
import com.example.weatherlowes.databinding.FragmentDetailsBinding
import com.example.weatherlowes.loadImage


class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentDetailsBinding.bind(view).apply {
            val iconPath = args.details.weather[0].icon + ".png"
            tvActTemp.text = args.details.main.temp.toInt().toString()
            tvFeelsLikeTempNumb.text = args.details.main.feelsLike.toInt().toString()
            tvDetailsFurther.text = args.details.weather[0].description
            tvDetails.text = args.details.weather[0].main
            ivWeatherImage.loadImage("https://openweathermap.org/img/w/$iconPath")
            toolbarDetails.setNavigationOnClickListener { findNavController().navigateUp() }
        }
    }
}
