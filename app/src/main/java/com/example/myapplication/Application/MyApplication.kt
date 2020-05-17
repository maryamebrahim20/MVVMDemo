package com.example.myapplication.Application

import android.app.Application
import com.example.myapplication.Remote.APIServices
import com.example.myapplication.Repository.WeatherRepo
import com.example.myapplication.ViewModel.WeatherViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication :Application() {
//
//    var listOfModules = module {
//        single { APIServices().createAuthService() }
//    }

    val repositoryModule = module {
        single { WeatherRepo() }

    }

    val ViewModelModule = module {
        viewModel { WeatherViewModel(get()) }

    }


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    repositoryModule,
                    ViewModelModule
                )
                )
        }

    }
}