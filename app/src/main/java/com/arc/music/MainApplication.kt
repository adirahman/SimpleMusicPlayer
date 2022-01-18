package com.arc.music

import android.app.Application
import com.androidnetworking.AndroidNetworking

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(applicationContext)
    }
}