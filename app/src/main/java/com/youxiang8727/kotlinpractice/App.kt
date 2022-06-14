package com.youxiang8727.kotlinpractice

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    init {
        Log.d(Constant.LOG_TAG, "App created!!")
    }
}