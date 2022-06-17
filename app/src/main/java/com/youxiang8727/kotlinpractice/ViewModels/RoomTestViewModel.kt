package com.youxiang8727.kotlinpractice.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.youxiang8727.kotlinpractice.Database.Word
import com.youxiang8727.kotlinpractice.Database.WordDao
import com.youxiang8727.kotlinpractice.Database.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RoomTestViewModel @Inject constructor(
    private val wordRepository: WordRepository
): ViewModel() {
    suspend fun insertWord(word: Word){
        wordRepository.insertWord(word)
    }

    fun getAllWordsLiveData():LiveData<List<Word>>{
        return wordRepository.getAllWordsLiveData()
    }
}