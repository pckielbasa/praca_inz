package com.example.praca_inz.ui.food.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praca_inz.property.ContactProperty
import com.example.praca_inz.property.FoodProperty

class DetailFoodViewModel(foodProperty: FoodProperty, app:Application): AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<FoodProperty>()

    val selectedProperty: LiveData<FoodProperty>
        get() = _selectedProperty

    init {
        _selectedProperty.value = foodProperty
    }
}