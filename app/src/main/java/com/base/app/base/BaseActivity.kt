package com.base.app.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.base.app.app.MrApplication
import com.base.app.di.component.ActivityComponent
import com.base.app.di.component.DaggerActivityComponent

/**
 * Created by HASEE on 2018/4/8.
 */
open class BaseActivity : AppCompatActivity() {


    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent.builder().appComponent((application as MrApplication).appcomponent)
                .build()
    }
}