package com.example.praca_inz.ui.food.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddFoodViewModel : ViewModel() {
    private val _goToFood = MutableLiveData<Boolean>()
    val goToFood : LiveData<Boolean>
        get() = _goToFood

    fun foodStart(){
        _goToFood.value = true
    }
    fun foodFinish(){
        _goToFood.value = false
    }
}