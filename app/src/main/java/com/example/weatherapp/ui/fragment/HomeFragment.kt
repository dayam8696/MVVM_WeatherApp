package com.example.weatherapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.weatherapp.ViewModel.WeatherViewModel
import com.example.weatherapp.databinding.HomeFragmentBinding
import com.example.weatherapp.ui.activites.MainActivity
import com.example.weatherapp.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeFragment :BaseFragment() {
    private val binding by lazy { HomeFragmentBinding.inflate(layoutInflater) }
    lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewmodel

        viewModel.getCurrentWeather()

        viewModel.currentWeatheer.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { weatherResponse ->
                        binding.tvTemp.text = weatherResponse.main.temp.toString()

                        Log.d("DYM", weatherResponse.toString())
                    }
                }

                is Resource.Error -> {

                    response.message?.let { message ->
                        Log.d("DYM", message)
                    }

                }

                is Resource.Loading -> {

                }
            }
        }

    }
}