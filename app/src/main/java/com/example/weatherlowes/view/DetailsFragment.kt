package com.example.weatherlowes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.weatherlowes.databinding.FragmentDetailsBinding
import com.example.weatherlowes.viewmodel.MainViewModel

//Add binding and use the mainViewModel Class to pass the ViewModel through the Fragment so
//The data has a place to be bound and is populated from the API Correctly using

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel by viewModels<MainViewModel>()
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    //Set the created View equal to the FrgamentDetails to inflate the app UI
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDetailsBinding.inflate(inflater, container, false).also { binding = it }.root

    //On the View Created use binding.apply to get the binding data to the right UI Component
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            binding.tvActTemp.text = args.details.main.temp.toInt().toString()
            binding.tvFeelsLikeTempNumb.text = args.details.main.feels_like.toInt().toString()
            binding.tvDetailsFurther.text = args.details.weather[0].description
            binding.tvDetails.text = args.details.weather[0].main
        }
        //This is copy paste to get the toolbar back arrow to work
        binding.toolbarDetails.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}
