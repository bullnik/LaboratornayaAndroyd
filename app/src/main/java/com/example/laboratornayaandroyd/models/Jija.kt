package com.example.laboratornayaandroyd.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jija")
class Jija (

    @PrimaryKey val id: Int,

    val name: String

)