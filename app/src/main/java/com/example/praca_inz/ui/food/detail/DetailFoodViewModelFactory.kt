package com.example.praca_inz.ui.food.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.property.FoodProperty

class DetailFoodViewModelFactory (
    private val foodProperty:FoodProperty,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailFoodViewModel::class.java)) {
            return DetailFoodViewModel(foodProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}