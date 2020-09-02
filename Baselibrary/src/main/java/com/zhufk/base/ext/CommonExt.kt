package com.zhufk.base.ext

import android.view.View
import android.widget.Button
import android.widget.EditText
import com.kotlin.base.widgets.DefaultTextWatcher
import com.trello.rxlifecycle.LifecycleProvider
import com.zhufk.base.data.protocol.BaseResp
import com.zhufk.base.rx.BaseFunc
import com.zhufk.base.rx.BaseFuncBoolean
import com.zhufk.base.rx.BaseSubscriber
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * @ClassName CommonExt
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 10:16
 * @Version 1.0
 */
fun <T> Observable<T>.excute(subscriber: BaseSubscriber<T>, lifecycleProvider: LifecycleProvider<*>) {
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .compose(lifecycleProvider.bindToLifecycle())
        .subscribe(subscriber)
}

fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
    return this.flatMap(BaseFunc())
}

fun <T> Observable<BaseResp<T>>.convertBoolean(): Observable<Boolean> {
    return this.flatMap(BaseFuncBoolean())
}

fun View.onClick(listener: View.OnClickListener): View {
    setOnClickListener(listener)
    return this
}

fun View.onClick(block: () -> Unit): View {
    setOnClickListener { block() }
    return this
}

fun Button.enable(et: EditText, block: () -> Boolean) {
    val btn = this
    et.addTextChangedListener(object : DefaultTextWatcher() {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = block()
        }
    })
}