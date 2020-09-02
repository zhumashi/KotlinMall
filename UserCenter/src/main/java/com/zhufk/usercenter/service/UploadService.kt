package com.zhufk.usercenter.service

import rx.Observable


/**
 * @ClassName UploadService
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/30 18:07
 * @Version 1.0
 */
interface UploadService {
    fun getUploadToken(): Observable<String>
}