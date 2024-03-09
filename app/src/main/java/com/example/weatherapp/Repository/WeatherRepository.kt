package com.example.weatherapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.api.RetrofitInstance
import com.example.weatherapp.api.WeatherApi
import com.example.weatherapp.model.CurrentWeather
import com.example.weatherapp.utils.Constants.API_KEY
import okhttp3.Response

class WeatherRepository(val api: WeatherApi) {

    suspend fun getCurrentWeather(lat: Double, lng: Double, unit: String): LiveData<Response<CurrentWeather>> {
        val liveData = MutableLiveData<Response<CurrentWeather>>()

        try {
            val response = api.getCurrentWeather(lat, lng, unit)
            if (response.isSuccessful) {
                liveData.postValue(Response.Success(response.body()))
            } else {
                liveData.postValue(Response.Error("Error occurred: ${response.message()}"))
            }
        } catch (e: Exception) {
            liveData.postValue(Response.Error("Error occurred: ${e.message}"))
        }

        return liveData
    }
}
