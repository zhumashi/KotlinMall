package com.zhufk.usercenter.persenter.view

import com.zhufk.base.presenter.view.BaseView
import com.zhufk.usercenter.data.protocol.UserInfo


/**
 * @ClassName RegisterView
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 9:40
 * @Version 1.0
 */
interface LoginView : BaseView {
    fun onLoginResult(result: UserInfo)
}