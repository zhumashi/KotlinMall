package com.zhufk.base.rx

import com.zhufk.base.common.ResultCode
import com.zhufk.base.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1


/**
 * @ClassName BaseFunc
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/28 21:17
 * @Version 1.0
 */
class BaseFunc<T> : Func1<BaseResp<T>, Observable<T>> {
    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != ResultCode.SUCCESS) {
            return Observable.error(BaseException(t.status, t.message))
        }
        return Observable.just(t.data)
    }

}