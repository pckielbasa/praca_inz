package com.example.praca_inz.network

import android.widget.Toast
import com.example.praca_inz.data.Contact
import com.example.praca_inz.data.Food
import com.example.praca_inz.data.User
import com.google.firebase.auth.FirebaseAuth
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
                    onResult(addedFood)
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
                    onResult(addedContact)
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


}