package com.example.laboratornayaandroyd.dagger

import com.example.laboratornayaandroyd.models.Database
import com.example.laboratornayaandroyd.models.MockApiService
import dagger.Component

@Component(modules = [ServiceModule::class, DatabaseModule::class])
interface AppComponent {

    val mockApiService: MockApiService

    val database: Database

}