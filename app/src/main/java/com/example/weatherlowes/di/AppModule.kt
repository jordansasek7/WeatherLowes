package com.example.weatherlowes.di

import com.example.weatherlowes.repo.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    @Singleton
    @Provides
    fun provideClient() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        .let {
            OkHttpClient.Builder().addInterceptor(it).build()
        }


    @Singleton
    @Provides
    fun provideWeatherService(client: OkHttpClient): WeatherService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build().create(WeatherService::class.java)

}