package com.example.myapplication.ViewModel

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.DataModel.WeatherResponse
import com.example.myapplication.Repository.WeatherRepo

class WeatherViewModel( val weatherRepo : WeatherRepo) {

    private val weatherObj = MutableLiveData<WeatherResponse>()

    fun getWeather(appID: String,lat:String,long:String) = weatherRepo.getCurrentData(appID,lat, long)

    
    /// observers
    fun Weather(): MutableLiveData<WeatherResponse> {
        return weatherObj
    }
    

}