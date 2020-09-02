package com.zhufk.base.injection.module

import androidx.fragment.app.FragmentActivity
import com.zhufk.base.injection.ActivityScope
import dagger.Module
import dagger.Provides


/**
 * @ClassName ActivityModule
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/28 18:23
 * @Version 1.0
 */
@Module
class ActivityModule(private val activity: FragmentActivity) {

    @ActivityScope
    @Provides
    fun provideActivity(): FragmentActivity {
        return this.activity
    }
}
