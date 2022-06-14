package com.youxiang8727.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.youxiang8727.kotlinpractice.CommonFunc.setSingleClickListener
import com.youxiang8727.kotlinpractice.HiltPractice.Truck
import com.youxiang8727.kotlinpractice.ViewModels.HiltTestViewModel
import com.youxiang8727.kotlinpractice.databinding.ActivityHiltTestBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHiltTestBinding
    private lateinit var viewModel: HiltTestViewModel
    @Inject
    lateinit var truck: Truck

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hilt_test)
        viewModel = ViewModelProvider(this).get(HiltTestViewModel::class.java)

        binding.btnTest.setSingleClickListener {
            truck.test()
        }
    }
}