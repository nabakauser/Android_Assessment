package com.example.android_assessment.service

import com.example.android_assessment.data.remote.RecentTransactionModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUserList(): Response<ArrayList<RecentTransactionModel?>?>?
}