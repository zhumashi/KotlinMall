package com.zhufk.usercenter.data.api

import com.zhufk.base.data.protocol.BaseResp
import com.zhufk.usercenter.data.protocol.*
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * @ClassName UserApi
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 16:19
 * @Version 1.0
 */
interface UserApi {
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>

    @POST("userCenter/login")
    fun login(@Body req: LoginReq): Observable<BaseResp<UserInfo>>

    @POST("userCenter/forgetPwd")
    fun forgetPwd(@Body req: ForgetPwdReq): Observable<BaseResp<String>>

    @POST("userCenter/resetPwd")
    fun resetPwd(@Body req: ResetPwdReq): Observable<BaseResp<String>>

    @POST("userCenter/editUser")
    fun editUser(@Body req:EditUserReq):Observable<BaseResp<UserInfo>>

}