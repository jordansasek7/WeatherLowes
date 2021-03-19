package com.example.weatherlowes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherlowes.databinding.WeatherItemBinding
import com.example.weatherlowes.model.AllData
import com.example.weatherlowes.view.TemperatureDirections

//extend the recycler view and use the custom Temperature ViewHolder for the view to set the Temperatur
//UI to make the data bound. In this case there needs to be an action to take the user from the recycler view
//to the next page to get the details

class TemperatureAdapter(val weather: List<AllData>) :
    RecyclerView.Adapter<TemperatureAdapter.TemperatureViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemperatureViewHolder {
        val binding: WeatherItemBinding =
            WeatherItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TemperatureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TemperatureViewHolder, position: Int) {
        //use the method created in the view holder and pass through the position
        holder.setTemperature(weather[position])
    }

    //use this methode to get the weather at a specific element within the array
    override fun getItemCount(): Int {
        return weather.size
    }

    class TemperatureViewHolder(val binding: WeatherItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //set up the adapter view holder to hold the data needed
        //In this case the OnClickListener takes the user from the list to the next fragment for
        // the Details
        fun setTemperature(allData: AllData) {
            binding.tvTemp.text = "${allData.main.temp.toInt()}"
            binding.tvTypeWeather.text = "${allData.weather[0].main}"
            binding.root.setOnClickListener() {
                val action = TemperatureDirections.actionTemperatureToDetailsFragment2(allData)
                Navigation.findNavController(binding.root).navigate(action)
            }
        }
    }
}


