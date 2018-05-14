package com.base.app.base

import android.os.Bundle
import android.support.v4.app.Fragment
import com.base.app.app.MrApplication
import com.base.app.di.component.DaggerFragmentComponent
import com.base.app.di.component.FragmentComponent

/**
 * Created by HASEE on 2018/4/8.
 */
class BaseFragment : Fragment() {

    lateinit var fragmentComponent: FragmentComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.application?.let {
            fragmentComponent = DaggerFragmentComponent.builder().appComponent((it as MrApplication).appcomponent)
                    .build()
        }
    }
}