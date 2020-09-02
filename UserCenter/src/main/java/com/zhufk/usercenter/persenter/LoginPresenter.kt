package com.zhufk.usercenter.persenter

import com.zhufk.base.ext.excute
import com.zhufk.base.presenter.BasePresenter
import com.zhufk.base.rx.BaseSubscriber
import com.zhufk.usercenter.data.protocol.UserInfo
import com.zhufk.usercenter.persenter.view.LoginView
import com.zhufk.usercenter.service.impl.UserServiceImpl
import javax.inject.Inject

/**
 * @ClassName RegisterPresenter
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 9:46
 * @Version 1.0
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    lateinit var userService: UserServiceImpl

    fun login(mobile: String, pwd: String, pushId: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        userService.login(mobile, pwd, pushId)
            .excute(object : BaseSubscriber<UserInfo>(mView) {
                override fun onNext(t: UserInfo) {
                    mView.onLoginResult(t)
                }
            }, lifecycleProvider)
    }
}