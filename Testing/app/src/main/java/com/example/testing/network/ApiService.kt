package com.example.testing.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/yuhonas/free-exercise-db/main/dist/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface ApiService {
    @GET("exercises.json")
    suspend fun getAll(): Array<Exercise>
}

object ExerciseApi {
    val retrofitServiceApi: ApiService by lazy { retrofit.create(ApiService::class.java) }
}