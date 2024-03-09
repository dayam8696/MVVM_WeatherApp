package com.example.weatherapp.api

import com.example.weatherapp.model.CurrentWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// // https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=d1d76e6f74c25f60b602ac34a75cc0e5
interface WeatherApi {
    @GET("data/2.5/weather")
    fun getCurrentWeather(
        @Query("lat") lat :Double,
        @Query("lng") lng : Double,
        @Query("unit") unit : String,
        @Query("appid") ApiKey :String,
    ) :Call<CurrentWeather>
}