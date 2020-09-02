package com.zhufk.usercenter.injection.module

import com.zhufk.base.injection.PerComponentScope
import com.zhufk.usercenter.service.UserService
import com.zhufk.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides


/**
 * @ClassName UserModule
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 18:05
 * @Version 1.0
 */
@Module
class UserModule {

    @PerComponentScope
    @Provides
    fun provideUserService(userService: UserServiceImpl): UserService {
        return userService
    }
}