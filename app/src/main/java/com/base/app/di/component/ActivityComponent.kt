package com.base.app.di.component

import com.base.app.androidapplication.MainActivity
import com.base.app.base.BaseActivity
import com.base.app.di.AppComponent
import com.base.app.di.scope.MainScope
import dagger.Component

/**
 * Created by HASEE on 2018/4/8.
 */
@MainScope
@Component(dependencies = [AppComponent::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)


}