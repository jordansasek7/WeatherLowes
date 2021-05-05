package com.example.weatherlowes.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherlowes.R
import com.example.weatherlowes.adapter.TemperatureAdapter
import com.example.weatherlowes.databinding.FragmentTemperatureBinding
import com.example.weatherlowes.model.WeatherResponse
import com.example.weatherlowes.util.Resource
import com.example.weatherlowes.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TemperatureFragment : Fragment(R.layout.fragment_temperature) {

    private lateinit var binding: FragmentTemperatureBinding
    private val viewModel by activityViewModels<WeatherViewModel>()
    private val args: TemperatureFragmentArgs by navArgs()

    private val tempAdapter: TemperatureAdapter by lazy {
        TemperatureAdapter(this::weatherOnClick)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cityName = args.toDetails

        binding = FragmentTemperatureBinding.bind(view).apply {
            toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        }

        with(binding) {
            toolbar.apply {
                title = cityName
                navigationIcon = AppCompatResources.getDrawable(
                    requireContext(),
                    R.drawable.ic_baseline_arrow_back
                )
            }

            rvTemperatureItem.apply {
                adapter = tempAdapter
                addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
            }
        }

        viewModel.getWeatherData(cityName).observe(viewLifecycleOwner) { weatherData ->
            if (weatherData is Resource.Success) tempAdapter.updateWeatherList(weatherData.data.list) else if (weatherData is Resource.Error)
                Toast.makeText(context, weatherData.msg, Toast.LENGTH_LONG).show()
        }
    }

    private fun weatherOnClick(weatherResponse: WeatherResponse) {
        val action = TemperatureFragmentDirections.actionTemperatureToDetailsFragment2(weatherResponse, args.toDetails)
        findNavController().navigate(action)
    }
}