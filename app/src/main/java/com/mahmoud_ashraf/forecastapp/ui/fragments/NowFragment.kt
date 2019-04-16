package com.mahmoud_ashraf.forecastapp.ui.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.mahmoud_ashraf.forecastapp.R
import com.mahmoud_ashraf.forecastapp.ui.data.ApixuWeatherApiService
import kotlinx.android.synthetic.main.fragment_now.*
import kotlinx.android.synthetic.main.fragment_now.view.*
import kotlinx.coroutines.*
import retrofit2.HttpException


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
        val apiService = ApixuWeatherApiService()!!.create(ApixuWeatherApiService::class.java)

        // Todo this is for test fetching only ... will be edit later

        CoroutineScope(Dispatchers.IO).launch {

            val request = apiService.getCurrentWeather("London")

            try {
                val currentWeatherResponse = request.await()
                withContext(Dispatchers.Main) {
                    now_tv.text = currentWeatherResponse.toString()
                }

            } catch (e: HttpException) {
            Log.e("REQUEST++++++++", "Exception ${e.message}")
        } catch (e: Throwable) {
            Log.e("REQUEST++++++++", "Ooops: Something else went wrong ${e.message}")
        }
        }
    }





}
