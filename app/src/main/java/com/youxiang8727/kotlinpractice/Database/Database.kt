package com.youxiang8727.kotlinpractice.Database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Word::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun wordDao(): WordDao
}