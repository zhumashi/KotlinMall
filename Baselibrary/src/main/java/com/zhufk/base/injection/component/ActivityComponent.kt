package com.zhufk.base.injection.component

import android.app.Activity
import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.trello.rxlifecycle.LifecycleProvider
import com.zhufk.base.injection.ActivityScope
import com.zhufk.base.injection.module.ActivityModule
import com.zhufk.base.injection.module.LifecycleProviderModule
import dagger.Component


/**
 * @ClassName ActivityComponent
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/28 18:48
 * @Version 1.0
 */
@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class, LifecycleProviderModule::class])
interface ActivityComponent {
    fun activity(): FragmentActivity
    fun context(): Context
    fun lifecycleProvider(): LifecycleProvider<*>
}