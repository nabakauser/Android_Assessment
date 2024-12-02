package com.example.android_assessment.data.remote

class ApiResponse<out T>(
    val msg : String?,
    val data: T?,
) {
    companion object {
        fun <T> success(data: T?): ApiResponse<T> {
            return ApiResponse("SUCCESS", data)
        }

        fun <T> error (msg: String): ApiResponse<T> {
            return ApiResponse("ERROR - $msg",null)
        }
    }
}