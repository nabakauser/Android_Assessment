package com.example.android_assessment.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.component.KoinComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest : KoinComponent {

    private fun loggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private fun httpClient() =
        OkHttpClient.Builder().apply {
            addInterceptor(loggingInterceptor())
        }.build()

    private val retrofit = Retrofit.Builder()
        .apply {
            baseUrl("https://api.github.com/")
            addConverterFactory(GsonConverterFactory.create())
            client(httpClient())
        }.build()

    val client : ApiService by lazy { retrofit.create(ApiService::class.java) }
}