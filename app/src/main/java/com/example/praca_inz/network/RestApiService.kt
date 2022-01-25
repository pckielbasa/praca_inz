package com.example.praca_inz.network

import com.example.praca_inz.data.User
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
}