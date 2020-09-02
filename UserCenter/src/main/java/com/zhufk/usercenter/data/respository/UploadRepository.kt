package com.zhufk.usercenter.data.respository

import com.zhufk.base.data.net.RetrofitFactory
import com.zhufk.base.data.protocol.BaseResp
import com.zhufk.usercenter.data.api.UploadApi
import rx.Observable
import javax.inject.Inject


/**
 * @ClassName UploadRepository
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/30 18:04
 * @Version 1.0
 */
class UploadRepository @Inject constructor(){
    fun getUploadToken(): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UploadApi::class.java).getUploadToken()
    }
}