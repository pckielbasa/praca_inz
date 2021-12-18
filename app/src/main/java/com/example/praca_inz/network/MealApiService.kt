package com.example.praca_inz.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://10.0.2.2:8080/user/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MealApiService{
    @GET(value = "all")
    fun getProperties():
            Call<String>
}

object MealApi{
    val retrofitService : MealApiService by lazy {
        retrofit.create(MealApiService::class.java)
    }
}