package com.base.app.di

import com.base.app.app.MrApplication
import com.base.app.di.module.ApiModule
import com.base.app.di.module.RepositoryModule
import com.base.app.di.scope.BaseScope
import com.base.app.network.repository.AccountRepository
import dagger.Component

/**
 * Created by HASEE on 2018/4/8.
 */
@BaseScope
@Component(modules = [RepositoryModule::class, ApiModule::class])
interface AppComponent {

    fun inject(application: MrApplication)

    fun accountRepository(): AccountRepository

}