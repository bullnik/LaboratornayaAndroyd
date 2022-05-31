package com.example.laboratornayaandroyd.models.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.laboratornayaandroyd.models.User

@Dao
interface UserDao {

    @Insert
    suspend fun save(vararg user: User)

    @Query("select * from user")
    suspend fun getAll(): List<User>

}