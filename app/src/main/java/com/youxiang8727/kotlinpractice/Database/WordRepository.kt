package com.youxiang8727.kotlinpractice.Database

import androidx.lifecycle.LiveData
import javax.inject.Inject

class WordRepository @Inject constructor(private val wordDao: WordDao) {
    suspend fun insertWord(word: Word){
        wordDao.insertWord(word)
    }
    fun getAllWordsLiveData(): LiveData<List<Word>>{
        return wordDao.getAllWords()
    }
}