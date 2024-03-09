package com.example.weatherapp.api

import com.example.weatherapp.model.CurrentWeather
import com.example.weatherapp.utils.Constants.API_KEY
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// // https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=d1d76e6f74c25f60b602ac34a75cc0e5
interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("lat")
        lat :Double = 10.91,
        @Query("lng")
        lng : Double = 42.34,
        @Query("unit")
        unit : String = "metrics",
        @Query("appid")
        ApiKey :String = API_KEY,
    ) :Call<CurrentWeather>
}