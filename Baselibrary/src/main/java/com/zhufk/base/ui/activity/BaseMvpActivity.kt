package com.zhufk.base.ui.activity

import android.os.Bundle
import com.zhufk.base.common.BaseApplication
import com.zhufk.base.injection.component.ActivityComponent
import com.zhufk.base.injection.component.DaggerActivityComponent
import com.zhufk.base.injection.module.ActivityModule
import com.zhufk.base.injection.module.LifecycleProviderModule
import com.zhufk.base.presenter.BasePresenter
import com.zhufk.base.presenter.view.BaseView
import com.zhufk.base.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject


/**
 * @ClassName BaseMvpActivity
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 9:29
 * @Version 1.0
 */
abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent: ActivityComponent

    private lateinit var mLoadingDialog: ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()

        mLoadingDialog = ProgressLoading.create(this)
    }

    protected abstract fun injectComponent()

    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
            .appComponent((application as BaseApplication).appComponent)
            .activityModule(ActivityModule(this))
            .lifecycleProviderModule(LifecycleProviderModule(this))
            .build()
    }

    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    override fun onError(text: String) {
        toast(text)
    }

}