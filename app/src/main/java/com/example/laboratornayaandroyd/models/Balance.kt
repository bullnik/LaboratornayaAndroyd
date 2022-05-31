package com.example.laboratornayaandroyd.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "balance")
class Balance(
    @PrimaryKey val id: Int,
    val accNum: Int,
    val balance: Double,
    val nextPay: Double,
)