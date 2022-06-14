package com.youxiang8727.kotlinpractice.ViewModels

import android.content.Context
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){
    fun getActivities(context: Context): List<ActivityInfo>{
        return context.packageManager.getPackageInfo(context.packageName, PackageManager.GET_ACTIVITIES).activities.map {
            it
        }.filterNot {
            Class.forName(it.name).name == context.javaClass.name
        }
    }


}