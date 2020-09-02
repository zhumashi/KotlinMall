package com.zhufk.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.kotlin.user.R
import com.zhufk.base.ext.enable
import com.zhufk.base.ext.onClick
import com.zhufk.base.ui.activity.BaseMvpActivity
import com.zhufk.usercenter.data.protocol.UserInfo
import com.zhufk.usercenter.injection.component.DaggerUserComponent
import com.zhufk.usercenter.injection.module.UserModule
import com.zhufk.usercenter.persenter.LoginPresenter
import com.zhufk.usercenter.persenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView() {
        mLoginBtn.enable(mMobileEt) { isBtnEnable() }
        mLoginBtn.enable(mPwdEt) { isBtnEnable() }

        mLoginBtn.onClick(this)
        mForgetPwdTv.onClick(this)
        mHeaderBar.getRightView().onClick(this)
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent)
            .userModule(UserModule()).build()
            .inject(this)

        mPresenter.mView = this
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mLoginBtn -> {
                mPresenter.login(mMobileEt.text.toString(), mPwdEt.text.toString(), "")
            }
            R.id.mRightTv -> {
                startActivity<RegisterActivity>()
            }
            R.id.mForgetPwdTv -> {
            }
        }
    }

    override fun onLoginResult(result: UserInfo) {
    }

    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }
}
