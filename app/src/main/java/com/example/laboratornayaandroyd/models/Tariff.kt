package com.example.laboratornayaandroyd.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tariff")
data class Tariff(
    @PrimaryKey val id: Int,
    val title: String,
    val desc: String,
    val cost: Double,
)