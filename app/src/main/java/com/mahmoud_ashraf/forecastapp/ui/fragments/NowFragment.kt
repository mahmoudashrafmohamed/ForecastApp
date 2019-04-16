package com.mahmoud_ashraf.forecastapp.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.mahmoud_ashraf.forecastapp.R
import com.mahmoud_ashraf.forecastapp.ui.data.ApixuWeatherApiService
import kotlinx.android.synthetic.main.fragment_now.*
import kotlinx.android.synthetic.main.fragment_now.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class NowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v =  inflater.inflate(R.layout.fragment_now, container, false)


        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val apiService = ApixuWeatherApiService()

        // Todo this is for test fetching only ... will be edit later
        GlobalScope.launch(Dispatchers.Main) {
            val currentWeatherResponse = apiService.getCurrentWeather("London").await()
            now_tv.text = currentWeatherResponse.toString()
        }
    }





}
