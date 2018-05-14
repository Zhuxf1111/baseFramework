package com.base.app.network.repository

import android.util.Log
import com.base.app.network.api.AccountApi
import javax.inject.Inject

/**
 * Created by HASEE on 2018/4/8.
 */
class AccountRepository @Inject constructor(private val mApi: AccountApi) {

    fun testFunction() {
        Log.d("test", "testFunction")
    }
}