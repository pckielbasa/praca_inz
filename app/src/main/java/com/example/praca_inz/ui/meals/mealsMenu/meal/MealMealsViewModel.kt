package com.example.praca_inz.ui.meals.mealsMenu.meal

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.authorization.login.LoginViewModel
import com.example.praca_inz.network.MealApi
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MealMealsViewModel  : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getUser()
    }

    private fun getUser(){
        MealApi.retrofitService.getProperties().enqueue( object: Callback,
            retrofit2.Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }
        })
    }

}