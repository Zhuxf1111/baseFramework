package com.base.app.androidapplication

import android.os.Bundle
import com.base.app.base.BaseActivity
import com.base.app.network.repository.AccountRepository
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var account: AccountRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)
        account.testFunction()
    }
}
