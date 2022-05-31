package com.example.laboratornayaandroyd.models

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MockApiService {

    @Provides
    suspend fun getBalance() : Balance {
        return RetrofitInstance.api.getBalance()[0]
    }

    @Provides
    suspend fun getTariffs() : List<Tariff> {
        return RetrofitInstance.api.getTariffs()
    }

    @Provides
    suspend fun getUser() : User {
        return RetrofitInstance.api.getUser()[0]
    }

}