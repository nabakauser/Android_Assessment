package com.example.android_assessment.service

import com.example.android_assessment.data.remote.ApiResponse
import com.example.android_assessment.data.remote.RecentTransactionModel
import retrofit2.Response

class ApiRepository(
    private val service: ApiService
) {

    suspend fun getTransactionUsers(): ApiResponse<ArrayList<RecentTransactionModel?>?> {
        return recentTransactionMappers(service.getUserList())
    }
}

fun recentTransactionMappers(users : Response<ArrayList<RecentTransactionModel?>?>?): ApiResponse<ArrayList<RecentTransactionModel?>?> {
    return if (users?.isSuccessful == true) ApiResponse.success(users.body())
    else ApiResponse.error(users?.message() ?: "error")
}