package com.example.myapplication.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface DoctorApiService {

        @GET("doctor/{id}")
        suspend fun getDoctorDetails(@Path("id") doctorId: String): Response<DoctorResponse>


    @POST("doctor/add-fav-Doctor")
    suspend fun addFavoriteDoctor(@Query("doctorId") doctorId: String)

    @POST("doctor/remove_fav_Doctor")
    suspend fun removeFavoriteDoctor(@Query("doctorId") doctorId: String)
}