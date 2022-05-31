package com.example.laboratornayaandroyd.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey val id: Long,
    val firstName: String,
    val lastName: String,
    val address: String,
)