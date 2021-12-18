package com.example.praca_inz.ui.meals.mealsMenu.meal

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.authorization.login.LoginViewModel

class MealMealsViewModel  : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getTestText()
    }

    private fun getTestText(){
        _response.value = "Test text"
    }

}