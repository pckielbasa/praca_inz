package com.example.praca_inz.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://10.0.2.2:8080/food/component/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface FoodApiService {
    @GET("all")
    fun getProperties():
            Call<String>
}


object FoodApi {
    val retrofitService : FoodApiService by lazy {
        retrofit.create(FoodApiService::class.java)
    }
}