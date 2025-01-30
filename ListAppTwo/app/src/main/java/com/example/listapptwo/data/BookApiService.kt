package com.example.listapptwo.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://stephen-king-api.onrender.com/api/books"

val retrofitBuilder = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface BookApiService {
    @GET
    suspend fun getAllBooks()
}

object BookApi {
    val retrofitServiceApi: BookApiService by lazy {
        retrofitBuilder.create(BookApiService::class.java)
    }
}