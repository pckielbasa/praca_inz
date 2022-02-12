package com.example.praca_inz.network

import com.example.praca_inz.data.*
import com.example.praca_inz.property.*
import kotlinx.coroutines.Deferred
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface JsonPlaceholderApi {
    //GET MAPPING


    @GET("myfood")
    fun getMyFoodsAsync(@Query("type") type: String,
                        @Query("username") username: String):
            Deferred<List<MyFoodProperty>>

    @GET("mycontact")
    fun getMyContactsAsync(@Query("type") type: String,
                        @Query("username") username: String):
            Deferred<List<MyContactProperty>>

    @GET("myday")
    fun getMyDayAsync(@Query("date") date: String,
                      @Query("username") username: String):
            Call<List<MyDayProperty>>

    @GET("myallergies")
    fun getMyAllergiesAsync(@Query("type") type: String,
                      @Query("username") username: String):
            Call<List<MyAllergiesProperty>>

    @GET("findallergy")
    fun getAllergyByAllergenIdAsync(@Query("allergenId") allergenId: String):
            Call<String>


    //POST MAPPING
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

    @Headers("Content-Type: application/json")
    @POST("add")
    fun sendCalendarData(
        @Body daySchedule: DaySchedule
    ): Call<DaySchedule>

    @Headers("Content-Type: application/json")
    @POST("add")
    fun sendAllergiesData(
        @Body allergiesReport: AllergiesReport
    ): Call<AllergiesReport>

    //DELETE MAPPING
    @DELETE("delete")
    fun deleteFood (@Query("foodId") foodId:String,
                    @Query("username") username:String):
           Call<Void?>?

    @DELETE("delete")
    fun deleteContact (@Query("contactId") contactId:String,
                    @Query("username") username:String):
            Call<Void?>?

    @DELETE("delete")
    fun deleteAllergy (@Query("allergiesId") allergiesId:String,
                       @Query("username") username:String):
            Call<Void?>?

}