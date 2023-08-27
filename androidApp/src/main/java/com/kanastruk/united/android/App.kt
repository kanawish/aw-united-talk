package com.kanastruk.united.android

import android.app.Application
import android.content.SharedPreferences
import appSharedPrefs
import com.kanastruk.united.BuildConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.SupervisorJob
import timber.log.Timber

@OptIn(ExperimentalCoroutinesApi::class)
class App : Application() {
    private val appScope = CoroutineScope(SupervisorJob())

    // 🐷 Template/sandbox stuff, replace when serious. ☕️🔥
    private val prefs:SharedPreferences by lazy {
        this@App.appSharedPrefs()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
