package com.example.weatherlowes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.weatherlowes.databinding.FragmentSearchBinding
import com.example.weatherlowes.viewmodel.MainViewModel


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel by viewModels<MainViewModel>()
//    private val args: SearchFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = FragmentSearchBinding.inflate(inflater, container, false).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLookUp.setOnClickListener {
            if(binding.etCityName.text?.isEmpty() == true){
            }
            else {
                val action =
                    SearchFragmentDirections.actionSearchFragmentToTemperature2(binding.etCityName.text.toString())
                binding.root.findNavController().navigate(action)
            }
        }
    }
}