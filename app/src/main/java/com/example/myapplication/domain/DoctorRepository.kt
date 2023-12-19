package com.example.myapplication.domain

// DoctorRepository.kt
interface DoctorRepository {
    suspend fun addFavoriteDoctor(doctorId: String)
    suspend fun removeFavoriteDoctor(doctorId: String)
    suspend fun getDoctorDetails(doctorId: String): Doctor
}
