package com.zhufk.usercenter.persenter.view

import com.zhufk.base.presenter.view.BaseView
import com.zhufk.usercenter.data.protocol.UserInfo


/**
 * @ClassName UserInfoView
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/30 18:09
 * @Version 1.0
 */
interface UserInfoView : BaseView {

    //获取上传凭证回调
    fun onGetUploadTokenResult(result: String)

    //编辑用户资料回调
    fun onEditUserResult(result: UserInfo)
}