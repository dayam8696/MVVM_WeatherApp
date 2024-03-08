package com.example.weatherapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.databinding.HomeFragmentBinding

class HomeFragment :BaseFragment() {
    private val binding by lazy {HomeFragmentBinding.inflate(layoutInflater)}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding .root
    }


}