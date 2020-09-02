package com.zhufk.base.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.zhufk.base.R
import com.zhufk.base.common.AppManager
import com.zhufk.base.ext.onClick
import kotlinx.android.synthetic.main.layout_header_bar.view.*


/**
 * @ClassName HeaderBar
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/30 8:47
 * @Version 1.0
 */
class HeaderBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    //是否显示返回按钮
    private var isShowBack = true
    //标题
    private var titleText: String? = null
    //右侧文字
    private var rightText: String? = null

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar)
        isShowBack = typedArray.getBoolean(R.styleable.HeaderBar_isShowBack, true)
        titleText = typedArray.getString(R.styleable.HeaderBar_titleText)
        rightText = typedArray.getString(R.styleable.HeaderBar_rightText)
        initView()
        typedArray.recycle()
    }

    private fun initView() {
        View.inflate(context, R.layout.layout_header_bar, this)
        mLeftIv.visibility = if (isShowBack) View.VISIBLE else View.GONE
        titleText?.let {
            mTitleTv.text = it
        }
        rightText?.let {
            mRightTv.text = it
        }

        //返回按钮 默认关闭当前Activity
        mLeftIv.onClick {
            if (context is FragmentActivity) {
                //TODO 下面两种方式验证
                AppManager.instance.finishActivity((context as FragmentActivity))
//                (context as FragmentActivity).finish()
            }
        }
    }

    fun getLeftView(): ImageView {
        return mLeftIv
    }

    fun getRightView(): TextView {
        return mRightTv
    }

    fun getRightText(): String {
        return mRightTv.text.toString()
    }
}