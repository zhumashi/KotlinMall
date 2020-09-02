package com.zhufk.usercenter.injection.module

import com.zhufk.usercenter.service.UploadService
import com.zhufk.usercenter.service.impl.UploadServiceImpl
import dagger.Module
import dagger.Provides


/**
 * @ClassName UploadModule
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/30 18:05
 * @Version 1.0
 */
@Module
class UploadModule {
    @Provides
    fun provideUploadService(uploadService: UploadServiceImpl): UploadService {
        return uploadService
    }
}