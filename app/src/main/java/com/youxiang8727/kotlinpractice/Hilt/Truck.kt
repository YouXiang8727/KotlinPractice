package com.youxiang8727.kotlinpractice.Hilt

import android.util.Log
import com.youxiang8727.kotlinpractice.Constant
import javax.inject.Inject

class Truck @Inject constructor(){
    init {
        Log.d(Constant.LOG_TAG, "Truck created!!")
    }

    fun test(){
        Log.d(Constant.LOG_TAG, "Truck test()")
    }
}