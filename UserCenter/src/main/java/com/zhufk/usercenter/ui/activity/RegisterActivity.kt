package com.zhufk.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.kotlin.user.R
import com.zhufk.base.ext.enable
import com.zhufk.base.ext.onClick
import com.zhufk.base.ui.activity.BaseMvpActivity
import com.zhufk.usercenter.injection.component.DaggerUserComponent
import com.zhufk.usercenter.injection.module.UserModule
import com.zhufk.usercenter.persenter.RegisterPresenter
import com.zhufk.usercenter.persenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        injectComponent()
        initView()
    }

    private fun initView() {
        mRegisterBtn.enable(mMobileEt) { isBtnEnable() }
        mRegisterBtn.enable(mVerifyCodeEt) { isBtnEnable() }
        mRegisterBtn.enable(mPwdEt) { isBtnEnable() }
        mRegisterBtn.enable(mPwdConfirmEt) { isBtnEnable() }
        mRegisterBtn.onClick(this)
        mVerifyCodeBtn.onClick(this)
    }

    public override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent)
            .userModule(UserModule())
            .build()
            .inject(this)
        mPresenter.mView = this
    }

    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.mRegisterBtn -> {
                mPresenter.register("", "", "")
            }
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证码成功")
            }
        }
    }

    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }
}
