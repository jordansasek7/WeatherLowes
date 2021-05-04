package com.example.weatherlowes.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.weatherlowes.R
import com.example.weatherlowes.adapter.TemperatureAdapter
import com.example.weatherlowes.databinding.FragmentTemperatureBinding
import com.example.weatherlowes.model.AllData
import com.example.weatherlowes.viewmodel.WeatherViewModel


class Temperature : Fragment(R.layout.fragment_temperature) {

    private lateinit var binding: FragmentTemperatureBinding
    private val viewModel by viewModels<WeatherViewModel>()
    private val args: TemperatureArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.city = args.toDetails
        binding = FragmentTemperatureBinding.bind(view).apply {
            toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        }

        viewModel.weather.observe(viewLifecycleOwner) { weatherData ->
            weatherData?.list?.let {
                binding.rvTemperatureItem.adapter = TemperatureAdapter(it, ::weatherOnClick)
            } ?: Toast.makeText(context, "Could not retrieve data", Toast.LENGTH_LONG).show()
        }
    }

    private fun weatherOnClick(allData: AllData) {
        val action = TemperatureDirections.actionTemperatureToDetailsFragment2(allData)
        findNavController().navigate(action)
    }
}