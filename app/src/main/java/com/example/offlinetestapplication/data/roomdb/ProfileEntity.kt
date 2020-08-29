package com.example.offlinetestapplication.data.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProfileEntity(
    @PrimaryKey
    val phoneNo: String,

    val name : String,
    val city : String,
    val state : String,
    val pinCode : Int
)