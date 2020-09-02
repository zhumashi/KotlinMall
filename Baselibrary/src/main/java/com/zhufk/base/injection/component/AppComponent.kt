package com.zhufk.base.injection.component

import android.content.Context
import com.zhufk.base.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton


/**
 * @ClassName AppComponent
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/28 18:45
 * @Version 1.0
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun context(): Context
}