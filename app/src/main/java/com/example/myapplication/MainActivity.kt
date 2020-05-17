package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.Constants.APIKEY
import com.example.myapplication.ViewModel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    var lat = "35"
    var lon = "139"

   // val viewModel: WeatherViewModel by lazy { ViewModelProviders.of(this).get(WeatherViewModel::class.java) }
    val viewModel :WeatherViewModel by inject()


            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.button).setOnClickListener {
            viewModel.getWeather(lat,lon, APIKEY)
            Listener()

        }
    }

    fun Listener() {

        viewModel.Weather().observe(this, Observer {
            if(it.weather!=null){
                val stringBuilder = "Country: " +
                        it.sys?.country +
                        "\n" +
                        "Temperature: " +
                        it.main?.temp +
                        "\n" +
                        "Temperature(Min): " +
                        it.main?.temp_min +
                        "\n" +
                        "Temperature(Max): " +
                        it.main?.temp_max +
                        "\n" +
                        "Humidity: " +
                        it.main?.humidity +
                        "\n" +
                        "Pressure: " +
                        it.main?.pressure

                textView.text= stringBuilder
            }


        })
    }
}
