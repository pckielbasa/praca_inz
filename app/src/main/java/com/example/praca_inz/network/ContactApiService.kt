package com.example.praca_inz.network

import com.example.praca_inz.property.ContactProperty
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://10.0.2.2:8080/contact/"

enum class ContactApiFilter(val type: String) { SHOW_CHEMISTRY("Chemistry"), SHOW_PLANT("Plant"), SHOW_ANIMAL("Animal") }

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface ContactApiService {
    @GET("type")
    fun getContactsAsync(@Query("type") type: String):
            Deferred<List<ContactProperty>>
}

object ContactApi {
    val retrofitService : ContactApiService by lazy {
        retrofit.create(ContactApiService::class.java)
    }
}