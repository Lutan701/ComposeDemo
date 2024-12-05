package com.demo.xx

import android.app.Application
import androidx.multidex.MultiDex
import com.demo.xx.model.db.DbProvider
import com.tencent.bugly.crashreport.CrashReport
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        // MultiDex
        MultiDex.install(this)
        // Bugly
        CrashReport.initCrashReport(this, "cd8d99f011", true)
        // Room
        DbProvider.init()
    }

}