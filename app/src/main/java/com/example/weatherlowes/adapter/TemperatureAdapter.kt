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

class TemperatureAdapter(
    private val weather: List<AllData>,
    private val weatherOnClick: (AllData) -> Unit
) : RecyclerView.Adapter<TemperatureAdapter.TemperatureViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemperatureViewHolder {
        val binding: WeatherItemBinding =
            WeatherItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TemperatureViewHolder(binding).apply {
            itemView.setOnClickListener { weatherOnClick.invoke(weather[adapterPosition]) }
        }
    }

    override fun onBindViewHolder(holder: TemperatureViewHolder, position: Int) {
        //use the method created in the view holder and pass through the position
        holder.setTemperature(weather[position])
    }

    //use this methode to get the weather at a specific element within the array
    override fun getItemCount(): Int {
        return weather.size
    }

    class TemperatureViewHolder(
        private val binding: WeatherItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun setTemperature(allData: AllData) {
            binding.tvTemp.text = "${allData.main.temp.toInt()}"
            binding.tvTypeWeather.text = allData.weather.firstOrNull()?.main ?: ""
        }
    }
}


