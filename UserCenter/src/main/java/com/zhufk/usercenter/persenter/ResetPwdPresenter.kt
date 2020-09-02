package com.zhufk.usercenter.persenter

import com.zhufk.base.ext.excute
import com.zhufk.base.presenter.BasePresenter
import com.zhufk.base.rx.BaseSubscriber
import com.zhufk.usercenter.persenter.view.ResetPwdView
import com.zhufk.usercenter.service.UserService
import javax.inject.Inject


/**
 * @ClassName ResetPwdPresenter
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/30 15:07
 * @Version 1.0
 */
class ResetPwdPresenter @Inject constructor(): BasePresenter<ResetPwdView>() {
    @Inject
    lateinit var userService: UserService


    /*
        重置密码
     */
    fun resetPwd(mobile: String, pwd: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        userService.resetPwd(mobile, pwd).excute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                if (t)
                    mView.onResetPwdResult("重置密码成功")
            }
        }, lifecycleProvider)

    }

}