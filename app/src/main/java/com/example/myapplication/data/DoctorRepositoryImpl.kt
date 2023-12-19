package com.example.myapplication.data

import com.example.myapplication.domain.Doctor
import com.example.myapplication.domain.DoctorRepository
import javax.inject.Inject

// DoctorRepositoryImpl.kt
class DoctorRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDoctorDataSource
) : DoctorRepository {

    override suspend fun addFavoriteDoctor(doctorId: String) {
        remoteDataSource.addFavoriteDoctor(doctorId)
    }

    override suspend fun removeFavoriteDoctor(doctorId: String) {
        remoteDataSource.removeFavoriteDoctor(doctorId)
    }

    override suspend fun getDoctorDetails(doctorId: String): Doctor {
        return remoteDataSource.getDoctorDetails(doctorId)
    }
}
