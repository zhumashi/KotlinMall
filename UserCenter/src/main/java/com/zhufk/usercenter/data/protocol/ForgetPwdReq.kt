package com.zhufk.usercenter.data.protocol


/**
 * @ClassName ForgetPwdReq
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/30 14:58
 * @Version 1.0
 */
data class ForgetPwdReq(val mobile: String, val verifyCode: String)