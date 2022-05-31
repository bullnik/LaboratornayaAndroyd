package com.example.laboratornayaandroyd.models.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.laboratornayaandroyd.models.Balance

@Dao
interface BalanceDao {

    @Insert
    suspend fun save(vararg balance: Balance)

    @Query("select * from balance")
    suspend fun getAll(): List<Balance>

}