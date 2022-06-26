package com.example.multiplatformapp.android.compose

import android.app.Application
import com.example.multiplatformapp.android.compose.api_calling.di.appModule
import com.example.multiplatformapp.api_calling.di.initKoin
import org.koin.android.ext.koin.androidContext

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
         initKoin {
             androidContext(this@BaseApplication)
             modules(appModule)
         }
    }
}