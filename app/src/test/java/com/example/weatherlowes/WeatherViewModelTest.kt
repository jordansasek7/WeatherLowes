package com.example.weatherlowes

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.weatherlowes.model.City
import com.example.weatherlowes.model.Coord
import com.example.weatherlowes.model.WeatherData
import com.example.weatherlowes.remote.WeatherRepo
import com.example.weatherlowes.util.Resource
import com.example.weatherlowes.view.DetailsFragmentArgs
import com.example.weatherlowes.viewmodel.WeatherViewModel
import io.mockk.every
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
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
    private lateinit var weatherRepo: WeatherRepo


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
        weatherViewModel = WeatherViewModel(weatherRepo)

    }

    @Test
    fun getCity_success() {

        val validQuery = "Philadelphia"
        weatherViewModel.args.
        every { weatherRepo.getWeatherDataFromName(validQuery)} returns
    flow {
        emit(Resource.Success<List<WeatherData>>(listOf()))
    }
        //Then resource is in success state
        val resource = weatherViewModel.

    }

