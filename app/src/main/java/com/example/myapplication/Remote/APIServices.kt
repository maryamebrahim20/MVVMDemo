package com.example.myapplication.Remote

import com.example.myapplication.DataModel.WeatherResponse
import retrofit2.Call
import retrofit2.Retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface APIServices {
    fun createAuthService(retrofit: Retrofit): APIServices {
        return retrofit.create(APIServices::class.java)
    }
    

    @GET("data/2.5/weather?")
    fun getCurrentWeatherData(@Query("lat") lat: String, @Query("lon") lon: String, @Query("APPID") app_id: String): Call<WeatherResponse>

}