package com.zhufk.base.ui.fragment

import android.os.Bundle
import com.zhufk.base.common.BaseApplication
import com.zhufk.base.injection.component.ActivityComponent
import com.zhufk.base.injection.component.DaggerActivityComponent
import com.zhufk.base.injection.module.ActivityModule
import com.zhufk.base.injection.module.LifecycleProviderModule
import com.zhufk.base.presenter.BasePresenter
import com.zhufk.base.presenter.view.BaseView
import javax.inject.Inject


/**
 * @ClassName BaseMvpActivity
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 9:29
 * @Version 1.0
 */
abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
    }

    protected abstract fun injectComponent()

    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
            .appComponent((activity?.application as BaseApplication).appComponent)
            .activityModule(ActivityModule(activity!!))
            .lifecycleProviderModule(LifecycleProviderModule(this))
            .build()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError(text: String) {
//        toast(text)
    }

}