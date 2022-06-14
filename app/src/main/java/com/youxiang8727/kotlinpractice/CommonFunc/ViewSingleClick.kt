package com.youxiang8727.kotlinpractice.CommonFunc

import android.os.SystemClock
import android.view.View

fun View.setSingleClickListener(listener: (View) -> Unit){
    var lastClickTime: Long = 0
    this.setOnClickListener{
        if (SystemClock.elapsedRealtime() - lastClickTime > 500){
            lastClickTime = SystemClock.elapsedRealtime()
            listener(it)
        }
    }
}