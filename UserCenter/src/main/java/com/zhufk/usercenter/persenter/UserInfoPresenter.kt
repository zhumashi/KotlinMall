package com.zhufk.usercenter.persenter

import com.zhufk.base.ext.excute
import com.zhufk.base.presenter.BasePresenter
import com.zhufk.base.rx.BaseSubscriber
import com.zhufk.usercenter.data.protocol.UserInfo
import com.zhufk.usercenter.persenter.view.UserInfoView
import com.zhufk.usercenter.service.UploadService
import com.zhufk.usercenter.service.UserService
import javax.inject.Inject


/**
 * @ClassName UserInfoPresenter
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/30 18:10
 * @Version 1.0
 */
class UserInfoPresenter @Inject constructor():BasePresenter<UserInfoView>(){
    @Inject
    lateinit var userService: UserService

    @Inject
    lateinit var uploadService: UploadService

    /*
        获取七牛云上传凭证
     */
    fun getUploadToken(){
        if (!checkNetWork())
            return

        mView.showLoading()
        uploadService.getUploadToken().excute(object : BaseSubscriber<String>(mView){
            override fun onNext(t: String) {
                mView.onGetUploadTokenResult(t)
            }
        },lifecycleProvider)
    }

    /*
        编辑用户资料
     */
    fun editUser(userIcon:String,userName:String,userGender:String,userSign: String){
        if (!checkNetWork())
            return

        mView.showLoading()
        userService.editUser(userIcon,userName,userGender,userSign).excute(object :BaseSubscriber<UserInfo>(mView){
            override fun onNext(t: UserInfo) {
                mView.onEditUserResult(t)
            }
        },lifecycleProvider)
    }
}