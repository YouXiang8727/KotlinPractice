package com.youxiang8727.kotlinpractice.HiltPractice

import android.util.Log
import com.youxiang8727.kotlinpractice.Constant
import javax.inject.Inject

class Driver @Inject constructor(){
    init {
        Log.d(Constant.LOG_TAG, "Driver created!!")
    }
}