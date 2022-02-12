package com.example.praca_inz.network

import com.example.praca_inz.data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RestApiService {
    fun addUser(userData: User, onResult: (User?) -> Unit){
        val retrofit = UserServiceBuilder.buildService(JsonPlaceholderApi::class.java)
        retrofit.sendUserData(userData).enqueue(
            object : Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<User>, response: Response<User>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }
    fun addFood(foodData: Food, onResult: (Food?) -> Unit){
        val retrofit = FoodServiceBuilder.buildService(JsonPlaceholderApi::class.java)
        retrofit.sendFoodData(foodData).enqueue(
            object : Callback<Food> {
                override fun onFailure(call: Call<Food>, t: Throwable) {
                    onResult(null)

                }
                override fun onResponse( call: Call<Food>, response: Response<Food>) {
                    val addedFood = response.body()
                    if (response.code() == 200){
                        onResult(addedFood)
                    }else{
                        onResult(null)
                    }
                }
            }
        )
    }

    fun addContact(contactData: Contact, onResult: (Contact?) -> Unit){
        val retrofit = ContactServiceBuilder.buildService(JsonPlaceholderApi::class.java)
        retrofit.sendContactData(contactData).enqueue(
            object : Callback<Contact> {
                override fun onFailure(call: Call<Contact>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<Contact>, response: Response<Contact>) {
                    val addedContact = response.body()
                    if (response.code() == 200){
                        onResult(addedContact)
                    }else{
                        onResult(null)
                    }
                }
            }
        )
    }

    fun addDaySchedule(dayData: DaySchedule, onResult: (DaySchedule?) -> Unit){
        val retrofit = CalendarServiceBuilder.buildService(JsonPlaceholderApi::class.java)
        retrofit.sendCalendarData(dayData).enqueue(
            object : Callback<DaySchedule> {
                override fun onFailure(call: Call<DaySchedule>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<DaySchedule>, response: Response<DaySchedule>) {
                    val addedDaySchedule = response.body()
                    if (response.code() == 200){
                        onResult(addedDaySchedule)
                    }else{
                        onResult(null)
                    }
                }
            }
        )
    }

    fun addAllergy(allergyData: AllergiesReport, onResult: (AllergiesReport?) -> Unit){
        val retrofit = AllergiesServiceBuilder.buildService(JsonPlaceholderApi::class.java)
        retrofit.sendAllergiesData(allergyData).enqueue(
            object : Callback<AllergiesReport> {
                override fun onFailure(call: Call<AllergiesReport>, t: Throwable) {
                    onResult(null)

                }
                override fun onResponse( call: Call<AllergiesReport>, response: Response<AllergiesReport>) {
                    val addedAllergy = response.body()
                    if (response.code() == 200){
                        onResult(addedAllergy)
                    }else{
                        onResult(null)
                    }
                }
            }
        )
    }

    fun addItemDay(dayItem: DayItem, onResult: (DayItem?) -> Unit){
        val retrofit = DayServiceBuilder.buildService(JsonPlaceholderApi::class.java)
        retrofit.sendItemDayData(dayItem).enqueue(
            object : Callback<DayItem> {
                override fun onFailure(call: Call<DayItem>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<DayItem>, response: Response<DayItem>) {
                    val dayItem = response.body()
                    if (response.code() == 200){
                        onResult(dayItem)
                    }else{
                        onResult(null)
                    }
                }
            }
        )
    }

    fun deleteFood(foodName: String, username: String){
        val deleteRequest: Call<Void?>? = FoodApi.retrofitService.deleteFood(foodName,username)
        deleteRequest!!.enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {

            }

            override fun onFailure(call: Call<Void?>, t: Throwable) {

            }
        })
    }

    fun deleteContact(contactName: String, username: String){
        val deleteRequest: Call<Void?>? = ContactApi.retrofitService.deleteContact(contactName,username)
        deleteRequest!!.enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {

            }

            override fun onFailure(call: Call<Void?>, t: Throwable) {

            }
        })
    }

    fun deleteAllergy(allergiesId: String, username: String){
        val deleteRequest: Call<Void?>? = AllergiesApi.retrofitService.deleteAllergy(allergiesId,username)
        deleteRequest!!.enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {

            }

            override fun onFailure(call: Call<Void?>, t: Throwable) {

            }
        })
    }

}