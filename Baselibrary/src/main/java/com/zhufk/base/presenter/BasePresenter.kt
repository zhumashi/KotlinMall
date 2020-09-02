package com.zhufk.base.presenter

import android.content.Context
import com.kotlin.base.utils.NetWorkUtils
import com.trello.rxlifecycle.LifecycleProvider
import com.zhufk.base.presenter.view.BaseView
import javax.inject.Inject


/**
 * @ClassName BasePresenter
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 9:23
 * @Version 1.0
 */
open class BasePresenter<T : BaseView> {

    lateinit var mView: T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    fun checkNetWork(): Boolean {
        if (NetWorkUtils.isNetWorkAvailable(context)) {
            return true
        }
        mView.onError("网络不可用")
        return false
    }
}