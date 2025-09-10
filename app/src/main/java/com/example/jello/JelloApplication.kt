package com.example.jello

import android.app.Application
import com.example.jello.di.chucker.ChuckerCrashHandler
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class JelloApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            initChucker()
        }
    }

    private fun initChucker() {
        val systemHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(
            ChuckerCrashHandler(
                systemHandler,
                this@JelloApplication
            )
        )
    }
}