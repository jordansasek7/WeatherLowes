package com.example.weatherlowes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherlowes.adapter.TemperatureAdapter
import com.example.weatherlowes.databinding.FragmentTemperatureBinding
import com.example.weatherlowes.viewmodel.MainViewModel


class Temperature : Fragment() {

    private lateinit var binding: FragmentTemperatureBinding
    private val viewModel by viewModels<MainViewModel>()
    val args: TemperatureArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = FragmentTemperatureBinding.inflate(inflater, container, false).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
//set up the adapter
        viewModel.weather.observe(this.viewLifecycleOwner, androidx.lifecycle.Observer {
            binding.rvTemperatureItem.layoutManager = LinearLayoutManager(this.context)
            binding.rvTemperatureItem.adapter =
                it.list?.let { list -> TemperatureAdapter(list) }
        })
        viewModel.getWeather(args.toDetails)
    }
}