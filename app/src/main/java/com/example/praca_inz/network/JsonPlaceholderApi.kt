package com.example.praca_inz.network

import com.example.praca_inz.data.Contact
import com.example.praca_inz.data.Food
import com.example.praca_inz.data.User
import com.example.praca_inz.property.*
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.*

interface JsonPlaceholderApi {
    @GET("type")
    fun getFoodsAsync(@Query("type") type: String,
                      @Query("username") username: String):
            Deferred<List<FoodProperty>>

    @GET("type")
    fun getContactsAsync(@Query("type") type: String,
                         @Query("username") username: String):
            Deferred<List<ContactProperty>>

    @GET("username")
    fun getUserByUsernameAsync(@Query("username") username: String) :
            Deferred<UserProperty>

    @GET("myfood")
    fun getMyFoodsAsync(@Query("type") type: String,
                        @Query("username") username: String):
            Deferred<List<MyFoodProperty>>

    @GET("mycontact")
    fun getMyContactsAsync(@Query("type") type: String,
                        @Query("username") username: String):
            Deferred<List<MyContactProperty>>

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

}