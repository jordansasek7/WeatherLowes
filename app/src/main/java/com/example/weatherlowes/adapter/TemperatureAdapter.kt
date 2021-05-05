package com.example.weatherlowes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherlowes.databinding.WeatherItemBinding
import com.example.weatherlowes.loadImage
import com.example.weatherlowes.model.WeatherResponse
import java.text.SimpleDateFormat
import java.util.*


class TemperatureAdapter(
    private val weatherOnClick: (WeatherResponse) -> Unit
) : RecyclerView.Adapter<TemperatureAdapter.TemperatureViewHolder>() {

    private var weatherList = listOf<WeatherResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemperatureViewHolder {
        val binding: WeatherItemBinding =
            WeatherItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TemperatureViewHolder(binding).apply {
            itemView.setOnClickListener { weatherOnClick.invoke(weatherList[adapterPosition]) }
        }
    }

    override fun onBindViewHolder(holder: TemperatureViewHolder, position: Int) {
        holder.setTemperature(weatherList[position])
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    class TemperatureViewHolder(
        private val binding: WeatherItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun setTemperature(weatherResponse: WeatherResponse) {
            val iconPath = weatherResponse.weather[0].icon + ".png"
            binding.tvTemp.text = "${weatherResponse.main.temp.toInt()}"
            binding.tvTypeWeather.text = weatherResponse.weather.firstOrNull()?.main ?: ""
            binding.ivWeatherImage.loadImage("https://openweathermap.org/img/w/$iconPath")

            val simpleDateFormat = SimpleDateFormat("M/d ha", Locale.getDefault()).apply {
                timeZone = TimeZone.getTimeZone("UTC")
            }
            binding.tvTime.text = simpleDateFormat.format(Date(weatherResponse.dt * 1000))
        }
    }

    fun updateWeatherList(weatherList: List<WeatherResponse>) {
        this.weatherList = weatherList
        this.notifyDataSetChanged()

    }
}


