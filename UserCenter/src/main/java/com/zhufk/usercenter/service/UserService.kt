package com.zhufk.usercenter.service

import com.zhufk.usercenter.data.protocol.UserInfo
import rx.Observable


/**
 * @ClassName UserService
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 10:06
 * @Version 1.0
 */
interface UserService {
    fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean>

    fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo>

    fun forgetPwd(mobile: String, verifyCode: String): Observable<Boolean>

    fun resetPwd(mobile: String, pwd: String): Observable<Boolean>

    //编辑用户资料
    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String):Observable<UserInfo>
}