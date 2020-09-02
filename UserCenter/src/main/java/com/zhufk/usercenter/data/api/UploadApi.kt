package com.zhufk.usercenter.data.api

import com.zhufk.base.data.protocol.BaseResp
import retrofit2.http.POST
import rx.Observable


/**
 * @ClassName UploadApi
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/30 18:02
 * @Version 1.0
 */
interface UploadApi {
    /*
        获取七牛云上传凭证
     */
    @POST("common/getUploadToken")
    fun getUploadToken(): Observable<BaseResp<String>>
}
