package com.example.praca_inz.network

import com.example.praca_inz.property.PersonProperty
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://10.0.2.2:8080/person/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface PersonApiService {
    @GET("all")
    fun getProperties():
            Call<List<PersonProperty>>
}


object PersonApi {
    val retrofitService : PersonApiService by lazy {
        retrofit.create(PersonApiService::class.java)
    }
}