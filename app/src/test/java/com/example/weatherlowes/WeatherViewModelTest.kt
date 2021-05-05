package com.example.weatherlowes

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.weatherlowes.model.City
import com.example.weatherlowes.model.Coord
import com.example.weatherlowes.model.WeatherData
import com.example.weatherlowes.model.WeatherResponse
import com.example.weatherlowes.repo.WeatherRepo
import com.example.weatherlowes.viewmodel.WeatherViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito.*
import org.robolectric.annotation.Config

@Config(manifest = Config.NONE)
@RunWith(AndroidJUnit4::class)
class WeatherViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var weatherViewModel: WeatherViewModel

    @Mock
    private lateinit var observer: Observer<WeatherData>

    @Mock
    private lateinit var weatherRepo: WeatherRepo

    @Captor
    private lateinit var argumentCaptor: ArgumentCaptor<WeatherData>

    private val weatherResponse = WeatherData(
        city = City(
            coord = Coord(lat = 1.1, lon = 1.1),
            country = "us",
            id = 1,
            name = "Philadelphia",
            population = 12,
            sunrise = 1,
            sunset = 2,
            timezone = 3
        ),
        cnt = 1,
        cod = "",
        list = listOf(),
        message = 33
    )

    @Before
    fun setup() {
        weatherViewModel = WeatherViewModel()
        weatherRepo = WeatherRepo()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getCity_success() = runBlocking {
        `when`(weatherRepo.getNameWeather("Philadelphia")).thenReturn(weatherResponse)

        verify(observer, times(1)).onChanged(argumentCaptor.capture())

        weatherViewModel.weather.observeForever { observer }

        weatherViewModel.city = "Philadelphia"

        val weatherValue = argumentCaptor.value
        assert(weatherValue == weatherResponse)
    }


}