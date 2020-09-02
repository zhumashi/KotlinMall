package com.zhufk.base.data.protocol


/**
 * @ClassName BaseResp
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/27 16:12
 * @Version 1.0
 */
data class BaseResp<out T>(val status: Int, val message: String, val data: T)