package com.example.weatherlowes.view

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weatherlowes.R
import com.example.weatherlowes.databinding.FragmentSearchBinding


class SearchFragment : Fragment(R.layout.fragment_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentSearchBinding.bind(view).apply {
            etCityName.doAfterTextChanged { btnLookUp.isEnabled = it.isNullOrBlank() == false }
            btnLookUp.setOnClickListener {
                etCityName.text?.toString()?.let {
                    if (it.isNotBlank()) findNavController().navigate(
                        SearchFragmentDirections.actionSearchFragmentToTemperature2(it)
                    )
                }
            }
        }
    }
}