package com.zhufk.base.ui.activity

import android.os.Bundle
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import com.zhufk.base.common.AppManager


/**
 * @ClassName BaseActivity
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 9:27
 * @Version 1.0
 */
open class BaseActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }
}