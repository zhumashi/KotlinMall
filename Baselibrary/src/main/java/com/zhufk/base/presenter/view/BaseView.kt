package com.zhufk.base.presenter.view


/**
 * @ClassName BaseView
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 9:22
 * @Version 1.0
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(text: String)
}