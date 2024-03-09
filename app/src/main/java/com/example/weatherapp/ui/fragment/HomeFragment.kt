package com.example.weatherapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.weatherapp.ViewModel.WeatherViewModel
import com.example.weatherapp.databinding.HomeFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeFragment :BaseFragment() {
    private val binding by lazy {HomeFragmentBinding.inflate(layoutInflater)}
    private val viewModel : WeatherViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        return binding .root

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.loadCurrentWeather(10.91, 44.34, "metric").observe(viewLifecycleOwner) { response ->
                // Handle the response here
                if (response.isSuccessful) {
                    showToast(response.body()?.visibility.toString())
                }else{
                    showToast("NULL")
                }
            }
        }



    }
}