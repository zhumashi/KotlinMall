package com.zhufk.usercenter.persenter

import com.zhufk.base.ext.excute
import com.zhufk.base.presenter.BasePresenter
import com.zhufk.base.rx.BaseSubscriber
import com.zhufk.usercenter.persenter.view.RegisterView
import com.zhufk.usercenter.service.impl.UserServiceImpl
import javax.inject.Inject

/**
 * @ClassName RegisterPresenter
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 9:46
 * @Version 1.0
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserServiceImpl

    fun register(mobile: String, verifyCode: String, pwd: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        userService.register(mobile, verifyCode, pwd)
            .excute(object : BaseSubscriber<Boolean>(mView) {
                override fun onNext(t: Boolean) {
                    if (t) {
                        mView.onRegisterResult("注册成功")
                    }
                }
            }, lifecycleProvider)
    }
}