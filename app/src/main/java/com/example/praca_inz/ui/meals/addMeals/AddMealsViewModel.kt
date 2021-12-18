package com.example.praca_inz.ui.meals.addMeals

import android.app.Application
import androidx.lifecycle.*


class AddMealsViewModel (app: Application) : AndroidViewModel(app){

    private val _closeAddMeal = MutableLiveData<Boolean>()
    val closeAddMeal : LiveData<Boolean>
        get() = _closeAddMeal

    fun closeAddMelMeals(){
        _closeAddMeal.value = true
    }

    fun closeAddMelMealsFinished(){
        _closeAddMeal.value = false
    }

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