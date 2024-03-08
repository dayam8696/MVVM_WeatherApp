package com.example.weatherapp.api

import com.example.weatherapp.model.CurrentWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather")
    fun getCurrentWeather(
        @Query("lat") lat :Double,
        @Query("lng") lng : Double,
        @Query("unit") unit : String,
        @Query("appid") ApiKey :String,
    ) :Call<CurrentWeather>
}