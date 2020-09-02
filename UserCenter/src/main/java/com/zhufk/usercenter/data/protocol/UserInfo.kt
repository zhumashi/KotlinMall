package com.zhufk.usercenter.data.protocol


/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/30 13:57
 * @Version 1.0
 */
data class UserInfo(
    val id: String,
    val userIcon: String,
    val userName: String,
    val userGender: String,
    val userMobile: String,
    val userSign: String
)