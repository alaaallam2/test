package com.example.myapplication.Hilt

import com.example.myapplication.data.DoctorApiService
import com.example.myapplication.data.RemoteDoctorDataSource
import com.example.myapplication.data.RemoteDoctorDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object RemoteDoctorDataSourceModule {

    @Provides
    fun provideRemoteDoctorDataSource(doctorApiService: DoctorApiService): RemoteDoctorDataSource {
        return RemoteDoctorDataSourceImpl(doctorApiService)
    }
}
