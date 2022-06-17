package com.youxiang8727.kotlinpractice

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import com.youxiang8727.kotlinpractice.CommonFunc.setSingleClickListener
import com.youxiang8727.kotlinpractice.Retrofit.PostResponse
import com.youxiang8727.kotlinpractice.ViewModels.CoroutineTestViewModel
import com.youxiang8727.kotlinpractice.databinding.ActivityCoroutineTestBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CoroutineTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoroutineTestBinding
    private val coroutineTestViewModel: CoroutineTestViewModel by viewModels()
    private var gson = GsonBuilder().setPrettyPrinting().create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        coroutineTestViewModel.postResponseMutableLiveData.observe(this) {
            binding.textViewPostResponse.text = gson.toJson(it)
        }
    }
}