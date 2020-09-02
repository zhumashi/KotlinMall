package com.zhufk.base.injection.module

import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides


/**
 * @ClassName LifecycleProviderModule
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/28 20:23
 * @Version 1.0
 */
@Module
class LifecycleProviderModule(private val lifecycleProvider: LifecycleProvider<*>) {

    @Provides
    fun provideLifecycleProvider(): LifecycleProvider<*> {
        return this.lifecycleProvider
    }
}
