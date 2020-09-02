package com.zhufk.base.injection.module

import android.content.Context
import com.zhufk.base.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * @ClassName AppModule
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/28 18:40
 * @Version 1.0
 */
@Module
class AppModule(private val context: BaseApplication) {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return this.context
    }
}
