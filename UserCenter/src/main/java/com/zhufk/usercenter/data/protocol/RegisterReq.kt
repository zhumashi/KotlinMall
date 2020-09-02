package com.zhufk.usercenter.data.protocol


/**
 * @ClassName RegisterReq
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 16:21
 * @Version 1.0
 */
data class RegisterReq(val mobile: String, val verifyCode: String, val pwd: String)