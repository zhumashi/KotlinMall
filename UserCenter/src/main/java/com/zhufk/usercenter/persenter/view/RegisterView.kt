package com.zhufk.usercenter.persenter.view

import com.zhufk.base.presenter.view.BaseView


/**
 * @ClassName RegisterView
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 9:40
 * @Version 1.0
 */
interface RegisterView : BaseView {
    fun onRegisterResult(result: String)
}