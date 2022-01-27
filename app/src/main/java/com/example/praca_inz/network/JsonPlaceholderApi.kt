package com.example.praca_inz.network

import com.example.praca_inz.data.Contact
import com.example.praca_inz.data.Food
import com.example.praca_inz.data.User
import com.example.praca_inz.property.UserProperty
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.*

interface JsonPlaceholderApi {


    @Headers("Content-Type: application/json")
    @POST("register")
    fun sendUserData(
        @Body user: User
    ): Call<User>

    @Headers("Content-Type: application/json")
    @POST("add")
    fun sendFoodData(
        @Body food: Food
    ): Call<Food>

    @Headers("Content-Type: application/json")
    @POST("add")
    fun sendContactData(
        @Body contact: Contact
    ): Call<Contact>

    @GET("")
    fun getUserByUsernameAsync(@Query("username") type: String):
            Deferred<List<UserProperty>>
}