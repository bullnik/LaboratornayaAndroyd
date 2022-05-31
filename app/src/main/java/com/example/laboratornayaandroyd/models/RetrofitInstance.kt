package com.example.laboratornayaandroyd.models

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://61f5894b62f1e300173c41ba.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: MockApi by lazy {
        retrofit.create(MockApi::class.java)
    }
}