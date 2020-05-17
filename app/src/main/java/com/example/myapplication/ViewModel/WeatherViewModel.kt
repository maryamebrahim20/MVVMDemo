package com.example.myapplication.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.DataModel.WeatherResponse
import com.example.myapplication.Repository.WeatherRepo

class WeatherViewModel( private val weatherRepo : WeatherRepo):ViewModel() {


    fun getWeather(lat:String,long:String,appID: String) = weatherRepo.getCurrentData(lat, long,appID)
    
    /// observers
    fun Weather(): MutableLiveData<WeatherResponse> {
        return weatherRepo.WeatherLiveData
    }

    

}