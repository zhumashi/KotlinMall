package com.zhufk.base.common

import android.app.Application
import android.content.Context
import com.zhufk.base.injection.component.AppComponent
import com.zhufk.base.injection.component.DaggerAppComponent
import com.zhufk.base.injection.module.AppModule


/**
 * @ClassName BaseApplication
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/28 18:41
 * @Version 1.0
 */
open class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initAppInjection()

        context =this
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object{
        lateinit var context: Context
    }
}