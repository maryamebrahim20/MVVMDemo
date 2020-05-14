package com.example.myapplication.Repository

import com.example.myapplication.DataModel.WeatherResponse
import com.example.myapplication.Remote.APIServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepo {


    fun getCurrentData(lat : String , lon :String , appID :String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(APIServices::class.java)
        val call = service.getCurrentWeatherData(lat, lon, appID)
        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!
                }
            }
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
            }
        })
    }
}