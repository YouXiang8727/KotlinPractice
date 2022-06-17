package com.youxiang8727.kotlinpractice.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youxiang8727.kotlinpractice.Retrofit.ApiService
import com.youxiang8727.kotlinpractice.Retrofit.PostRequest
import com.youxiang8727.kotlinpractice.Retrofit.PostResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoroutineTestViewModel @Inject constructor(
    apiService: ApiService
) : ViewModel() {
    val postResponseMutableLiveData: MutableLiveData<PostResponse> by lazy {
        MutableLiveData<PostResponse>(null)
    }

    init {
        viewModelScope.launch {
            postResponseMutableLiveData.value = apiService.post(PostRequest("TEST", 0)).body()
        }
    }

}