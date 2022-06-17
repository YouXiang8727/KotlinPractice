package com.youxiang8727.kotlinpractice.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WordDao {
    @Insert
    suspend fun insertWord(word: Word)
    @Query("SELECT * FROM Word")
    fun getAllWords(): LiveData<List<Word>>
}