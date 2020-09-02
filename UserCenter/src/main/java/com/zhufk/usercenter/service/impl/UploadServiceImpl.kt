package com.zhufk.usercenter.service.impl

import com.zhufk.base.ext.convert
import com.zhufk.usercenter.data.respository.UploadRepository
import com.zhufk.usercenter.service.UploadService
import rx.Observable
import javax.inject.Inject


/**
 * @ClassName UploadServiceImpl
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/30 18:07
 * @Version 1.0
 */
class UploadServiceImpl @Inject constructor():UploadService{
    @Inject
    lateinit var repository: UploadRepository

    override fun getUploadToken(): Observable<String> {
        return repository.getUploadToken().convert()
    }


}