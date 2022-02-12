package com.example.praca_inz.ui.calendar.selectFood.addFoodToDay

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.property.MyFoodProperty


class AddFoodToDayViewModelFactory (
    private val myFoodProperty: MyFoodProperty,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddFoodToDayViewModel::class.java)) {
            return AddFoodToDayViewModel(myFoodProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}