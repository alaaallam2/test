package com.example.myapplication.data

interface RemoteDoctorDataSource {
    suspend fun addFavoriteDoctor(doctorId: String)
    suspend fun removeFavoriteDoctor(doctorId: String)
}