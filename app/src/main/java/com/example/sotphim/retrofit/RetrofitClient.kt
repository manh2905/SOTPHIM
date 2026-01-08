package com.example.sotphim.retrofit

import com.example.sotphim.service.MoviewApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://phimapi.com/"

    val instance : MoviewApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviewApiService::class.java)
    }
}