package com.example.praca_inz.ui.meals.addMeals

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class AddMealsViewModel (app: Application) : AndroidViewModel(app){

    class AddMealsViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(AddMealsViewModel::class.java)) {
                AddMealsViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("AddMealsViewModel Not Found")
            }
        }
    }
}