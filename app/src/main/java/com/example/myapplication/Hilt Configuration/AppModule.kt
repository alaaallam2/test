package com.example.myapplication.Hilt

import com.example.myapplication.data.DoctorApiService
import com.example.myapplication.data.DoctorRepositoryImpl
import com.example.myapplication.data.RemoteDoctorDataSource
import com.example.myapplication.data.RemoteDoctorDataSourceImpl
import com.example.myapplication.domain.DoctorRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// AppModule.kt
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDoctorApiService(): DoctorApiService {
        return Retrofit.Builder()
            .baseUrl("https://eihospital.com/eihospital/api/doctor/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DoctorApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDoctorDataSource(doctorApiService: DoctorApiService): RemoteDoctorDataSource {
        return RemoteDoctorDataSourceImpl(doctorApiService)
    }

    @Provides
    @Singleton
    fun provideDoctorRepository(remoteDataSource: RemoteDoctorDataSource): DoctorRepository {
        return DoctorRepositoryImpl(remoteDataSource)
    }
}
