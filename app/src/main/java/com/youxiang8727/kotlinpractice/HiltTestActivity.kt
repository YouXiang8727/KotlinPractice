package com.youxiang8727.kotlinpractice

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.youxiang8727.kotlinpractice.CommonFunc.setSingleClickListener
import com.youxiang8727.kotlinpractice.Hilt.Truck
import com.youxiang8727.kotlinpractice.ViewModels.HiltTestViewModel
import com.youxiang8727.kotlinpractice.databinding.ActivityHiltTestBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHiltTestBinding
    private val hiltTestViewModel: HiltTestViewModel by viewModels()
    @Inject
    lateinit var truck: Truck

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hilt_test)

        binding.btnTest.setSingleClickListener {
            truck.test()
        }
    }
}