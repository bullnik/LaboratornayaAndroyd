package com.example.laboratornayaandroyd.models.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.laboratornayaandroyd.models.Jija

@Dao
interface JijaDao {

    @Insert
    suspend fun save(vararg jija: Jija)

    @Query("select * from jija")
    suspend fun getAll(): List<Jija>

    @Delete
    fun delete(jija: Jija)

}