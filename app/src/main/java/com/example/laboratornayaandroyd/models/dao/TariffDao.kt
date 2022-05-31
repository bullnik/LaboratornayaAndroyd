package com.example.laboratornayaandroyd.models.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.laboratornayaandroyd.models.Tariff

@Dao
interface TariffDao {

    @Insert
    suspend fun save(vararg tariff: Tariff)

    @Delete
    suspend fun delete(tariff: Tariff)

    @Query("select * from tariff")
    suspend fun getAll(): List<Tariff>

}