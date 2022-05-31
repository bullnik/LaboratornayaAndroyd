package com.example.laboratornayaandroyd.dagger

import com.example.laboratornayaandroyd.models.MockApiService
import dagger.Module
import dagger.Provides

@Module
class ServiceModule {

    @Provides
    fun provideMockApiService() : MockApiService {
        return MockApiService()
    }

}