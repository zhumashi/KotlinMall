package com.zhufk.usercenter.service.impl

import com.zhufk.base.ext.convert
import com.zhufk.base.ext.convertBoolean
import com.zhufk.usercenter.data.protocol.UserInfo
import com.zhufk.usercenter.data.respository.UserRepository
import com.zhufk.usercenter.service.UserService
import rx.Observable
import javax.inject.Inject

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 10:08
 * @Version 1.0
 */
class UserServiceImpl @Inject constructor() : UserService {

    @Inject
    lateinit var repository: UserRepository

    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {

        return repository.register(mobile, verifyCode, pwd)
            .convertBoolean()
    }

    override fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo> {

        return repository.login(mobile, pwd, pushId)
            .convert()
    }

    override fun forgetPwd(mobile: String, verifyCode: String): Observable<Boolean> {

        return repository.forgetPwd(mobile, verifyCode)
            .convertBoolean()
    }

    override fun resetPwd(mobile: String, pwd: String): Observable<Boolean> {

        return repository.resetPwd(mobile, pwd)
            .convertBoolean()
    }

    /*
        修改用户资料
     */
    override fun editUser(userIcon: String, userName: String, userGender: String, userSign: String): Observable<UserInfo> {
        return repository.editUser(userIcon,userName,userGender,userSign).convert()
    }


}