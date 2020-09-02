package com.zhufk.usercenter.injection.component

import com.zhufk.base.injection.PerComponentScope
import com.zhufk.base.injection.component.ActivityComponent
import com.zhufk.usercenter.injection.module.UploadModule
import com.zhufk.usercenter.injection.module.UserModule
import com.zhufk.usercenter.ui.activity.*
import dagger.Component


/**
 * @ClassName UserComponent
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 18:07
 * @Version 1.0
 */
@PerComponentScope
@Component(dependencies = [ActivityComponent::class], modules = [UserModule::class, UploadModule::class])
interface UserComponent {
    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ForgetPwdActivity)
    fun inject(activity: ResetPwdActivity)
    fun inject(activity: UserInfoActivity)
}