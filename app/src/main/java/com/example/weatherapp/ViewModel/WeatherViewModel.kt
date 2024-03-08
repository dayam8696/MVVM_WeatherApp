package com.example.weatherapp.ViewModel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.Repository.WeatherRepository
import com.example.weatherapp.api.RetrofitInstance
import com.example.weatherapp.api.WeatherApi
import retrofit2.create

class WeatherViewModel(val weatherRepository :WeatherRepository):ViewModel() {
    constructor() : this(WeatherRepository(RetrofitInstance().getClient().create(WeatherApi::class.java))
        fun currentWeather(lat:Double ,lng:Double, unit:String) =
            weatherRepository.getCurrentWeather(lat ,lng, unit)
}