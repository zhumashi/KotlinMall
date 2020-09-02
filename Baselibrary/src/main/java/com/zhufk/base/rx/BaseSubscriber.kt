package com.zhufk.base.rx

import com.zhufk.base.presenter.view.BaseView
import rx.Subscriber


/**
 * @ClassName BaseSubscriber
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 10:17
 * @Version 1.0
 */
open class BaseSubscriber<T>(val baseView: BaseView) :Subscriber<T>(){
    override fun onNext(t: T) {
    }

    override fun onCompleted() {
        baseView.hideLoading()
    }

    override fun onError(e: Throwable?) {
        baseView.hideLoading()
        if (e is BaseException){
            e.message?.let { baseView.onError(it) }
        }
    }

}