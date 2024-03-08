package com.example.weatherapp.Repository

import com.example.weatherapp.api.WeatherApi
import com.example.weatherapp.utils.Constants.API_KEY

class   WeatherRepository(val api:WeatherApi) {
    fun getCurrentWeather(lat:Double ,lng:Double, unit:String) =
        api.getCurrentWeather(lat,lng ,unit,API_KEY)
}