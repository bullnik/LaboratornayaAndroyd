package com.example.laboratornayaandroyd.models

import retrofit2.http.GET

interface MockApi {

    @GET("balance")
    suspend fun getBalance() : List<Balance>

    @GET("tariffs")
    suspend fun getTariffs() : List<Tariff>

    @GET("userInfo")
    suspend fun getUser() : List<User>
}