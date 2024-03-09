package com.example.weatherapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.Repository.WeatherRepository
import com.example.weatherapp.api.RetrofitInstance
import com.example.weatherapp.api.WeatherApi
import com.example.weatherapp.model.CurrentWeather
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.create

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val _currentWeather = MutableLiveData<CurrentWeather>()
    val currentWeather: LiveData<CurrentWeather> = _currentWeather

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

   suspend fun loadCurrentWeather(lat: Double, lng: Double, unit: String) {
        repository.getCurrentWeather(lat, lng, unit)
            .enqueue(object : Callback<CurrentWeather> {
                override fun onResponse(call: Call<CurrentWeather>, response: Response<CurrentWeather>) {
                    if (response.isSuccessful) {
                        _currentWeather.postValue(response.body())
                    } else {
                        _error.postValue("Failed to fetch weather data: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {
                    _error.postValue(t.message ?: "Unknown error")
                }
            })
    }
}





