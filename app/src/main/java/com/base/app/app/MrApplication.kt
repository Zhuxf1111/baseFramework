package com.base.app.app

import android.support.multidex.MultiDexApplication
import com.base.app.di.AppComponent
import com.base.app.di.DaggerAppComponent

/**
 * Created by HASEE on 2018/4/8.
 */
class MrApplication : MultiDexApplication() {

    lateinit var appcomponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appcomponent = DaggerAppComponent.create()
        appcomponent.inject(this)
    }
}