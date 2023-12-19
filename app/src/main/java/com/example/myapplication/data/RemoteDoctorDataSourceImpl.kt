package com.example.myapplication.data

import javax.inject.Inject

class RemoteDoctorDataSourceImpl @Inject constructor(
    private val doctorApiService: DoctorApiService
) : RemoteDoctorDataSource {

    override suspend fun addFavoriteDoctor(doctorId: String) {
        doctorApiService.addFavoriteDoctor(doctorId)
    }

    override suspend fun removeFavoriteDoctor(doctorId: String) {
        doctorApiService.removeFavoriteDoctor(doctorId)
    }
}