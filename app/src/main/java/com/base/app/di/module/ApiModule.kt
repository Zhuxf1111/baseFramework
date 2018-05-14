package com.base.app.di.module

import com.base.app.di.scope.BaseScope
import com.base.app.network.api.AccountApi
import com.base.app.network.frame.RetrofitHelper
import dagger.Module
import dagger.Provides

/**
 * Created by HASEE on 2018/4/8.
 */
@Module
class ApiModule {

    @Provides
    @BaseScope
    fun provideAccountApi(): AccountApi {
        return getApi(AccountApi::class.java)
    }

    private fun <T> getApi(clazz: Class<T>): T {
        return RetrofitHelper.getInstance().retrofit.create(clazz)
    }
}