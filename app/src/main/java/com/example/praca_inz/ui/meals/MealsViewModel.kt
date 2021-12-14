package com.example.praca_inz.ui.meals

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.ui.persons.addPerson.AddPersonViewModel

class MealsViewModel (app: Application) : AndroidViewModel(app) {

    private val _tabVariable = MutableLiveData<String>()
    val tabVariable : LiveData<String>
        get() = _tabVariable

    fun tabComponent(){
        _tabVariable.value = "Component"
    }
    fun tabSnack(){
        _tabVariable.value = "Snack"
    }

    fun tabMeals(){
        _tabVariable.value = "Meals"
    }
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