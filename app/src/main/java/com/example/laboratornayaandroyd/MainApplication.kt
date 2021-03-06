package com.example.laboratornayaandroyd

import android.app.Application
import com.example.laboratornayaandroyd.dagger.AppComponent
import com.example.laboratornayaandroyd.dagger.DaggerAppComponent
import com.example.laboratornayaandroyd.models.Database

class MainApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        Database.context = applicationContext
        appComponent = DaggerAppComponent.create()
    }
}
