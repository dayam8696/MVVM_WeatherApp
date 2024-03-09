package com.example.weatherapp.ViewModel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.Repository.WeatherRepository
import com.example.weatherapp.api.RetrofitInstance
import com.example.weatherapp.api.WeatherApi
import retrofit2.create

class WeatherViewModel(val repository :WeatherRepository):ViewModel() {
    constructor():this(WeatherRepository(RetrofitInstance().getClient().create(WeatherApi::class.java)))

    fun loadCurrentWeather(lat :Double ,lng :Double ,unit:String)=
        repository.getCurrentWeather(lat ,lng, unit)

}