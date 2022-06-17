package com.youxiang8727.kotlinpractice.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Word(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val chinese: String,
    val english: String
) {
}