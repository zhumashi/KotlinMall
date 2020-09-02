package com.zhufk.base.common

import android.app.ActivityManager
import android.content.Context
import androidx.fragment.app.FragmentActivity
import java.util.*


/**
 * @ClassName AppManager
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/30 8:25
 * @Version 1.0
 */
class AppManager private constructor() {

    private val activityStack: Stack<FragmentActivity> = Stack()

    companion object {

        val instance: AppManager by lazy {
            AppManager()
        }
    }

    fun addActivity(activity: FragmentActivity) {
        activityStack.add(activity)
    }

    fun finishActivity(activity: FragmentActivity) {
        activity.finish()
        activityStack.remove(activity)
    }

    fun currentActivity(activity: FragmentActivity): FragmentActivity {
        return activityStack.lastElement()
    }

    fun finishAllActivity() {
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()
    }

    fun exitApp(context: Context) {
        finishAllActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }
}