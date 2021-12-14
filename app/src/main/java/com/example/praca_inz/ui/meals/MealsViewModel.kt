package com.example.praca_inz.ui.meals

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.ui.persons.addPerson.AddPersonViewModel

class MealsViewModel (app: Application) : AndroidViewModel(app) {


    class MealsViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(MealsViewModel::class.java)) {
                MealsViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("MealsViewModel Not Found")
            }
        }
    }

}