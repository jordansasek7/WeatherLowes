package com.example.weatherlowes.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.weatherlowes.R
import com.example.weatherlowes.databinding.FragmentDetailsBinding

//Add binding and use the mainViewModel Class to pass the ViewModel through the Fragment so
//The data has a place to be bound and is populated from the API Correctly using

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentDetailsBinding.bind(view).apply {
            tvActTemp.text = args.details.main.temp.toInt().toString()
            tvFeelsLikeTempNumb.text = args.details.main.feels_like.toInt().toString()
            tvDetailsFurther.text = args.details.weather[0].description
            tvDetails.text = args.details.weather[0].main
            toolbarDetails.setNavigationOnClickListener { findNavController().navigateUp() }
        }
    }
}
