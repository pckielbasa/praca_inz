package com.example.praca_inz.ui.food.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.praca_inz.property.MyFoodProperty

class DetailFoodViewModel(myFoodProperty: MyFoodProperty, app: Application): AndroidViewModel(app) {

    private val _goToFood = MutableLiveData<Boolean>()
    val goToFood : LiveData<Boolean>
        get() = _goToFood

    fun foodStart(){
        _goToFood.value = true
    }
    fun foodFinish(){
        _goToFood.value = false
    }

    private val _selectedProperty = MutableLiveData<MyFoodProperty>()
    val selectedProperty: LiveData<MyFoodProperty>
        get() = _selectedProperty


    init {
        _selectedProperty.value = myFoodProperty
    }
}