package com.youxiang8727.kotlinpractice.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Model(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val chinese: String,
    val english: String
) {
}