package com.example.laboratornayaandroyd

import android.app.Application
import android.content.Context
import com.example.laboratornayaandroyd.dagger.AppComponent
import com.example.laboratornayaandroyd.dagger.DaggerAppComponent

class MainApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}