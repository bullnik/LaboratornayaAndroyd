package com.example.laboratornayaandroyd.dagger

import android.content.Context
import com.example.laboratornayaandroyd.models.Database
import com.example.laboratornayaandroyd.models.MockApiService
import dagger.Component

@Component(modules = [ServiceModule::class])
interface AppComponent {

    val mockApiService: MockApiService

   // fun database(context: Context): Database

}