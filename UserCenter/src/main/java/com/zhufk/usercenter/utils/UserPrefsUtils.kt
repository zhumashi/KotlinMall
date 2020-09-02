package com.zhufk.usercenter.utils

import com.kotlin.base.utils.AppPrefsUtils
import com.zhufk.base.common.BaseConstant
import com.zhufk.provider.common.ProviderConstant
import com.zhufk.usercenter.data.protocol.UserInfo


/**
 * @ClassName UserPrefsUtils
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/30 18:23
 * @Version 1.0
 */
object UserPrefsUtils {

    /*
        退出登录时，传入null,清空存储
     */
    fun putUserInfo(userInfo: UserInfo?) {
        AppPrefsUtils.putString(BaseConstant.KEY_SP_TOKEN, userInfo?.id ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_ICON, userInfo?.userIcon ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_NAME, userInfo?.userName ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_MOBILE, userInfo?.userMobile ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_GENDER, userInfo?.userGender ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_SIGN, userInfo?.userSign ?: "")
    }
}