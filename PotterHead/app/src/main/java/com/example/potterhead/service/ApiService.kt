package com.example.potterhead.service

import com.example.potterhead.entity.Spell
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://potterapi-fedeperin.vercel.app/en/"

//to create retrofit instance
private val retrofitBuilder = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

//defines api endpoints
interface ApiService {
    @GET("spells")
    suspend fun getAllSpells():List<Spell>
}

//created api object
object  PotterApiService {
    //lazy : creates instance only once when accessed or called , n same object reused across app
    val retrofitApiService :ApiService by lazy { retrofitBuilder.create(ApiService::class.java) }
}