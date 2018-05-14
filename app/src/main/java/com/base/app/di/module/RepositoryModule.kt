package com.base.app.di.module

import com.base.app.di.scope.BaseScope
import com.base.app.network.api.AccountApi
import com.base.app.network.repository.AccountRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by HASEE on 2018/4/8.
 */
@Module
class RepositoryModule {

    @Provides
    @BaseScope
    fun provideAccountRepository(api: AccountApi): AccountRepository {
        return AccountRepository(api)
    }

}