package com.example.potterhead.service

import com.example.potterhead.entity.Spell
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://potterapi-fedeperin.vercel.app/en/"

private val retrofitBuilder = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface ApiService {
    @GET("spells")
    suspend fun getAllSpells():List<Spell>
}

object  PotterApiService {
    val retrofitApiService :ApiService by lazy { retrofitBuilder.create(ApiService::class.java) }
}