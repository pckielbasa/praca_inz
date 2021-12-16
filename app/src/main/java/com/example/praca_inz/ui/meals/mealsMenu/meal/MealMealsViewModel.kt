package com.example.praca_inz.ui.meals.mealsMenu.meal

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.authorization.login.LoginViewModel

class MealMealsViewModel (app: Application) : AndroidViewModel(app) {

    private val _popupMenu = MutableLiveData<Boolean>()
    val popupMenu : LiveData<Boolean>
        get() = _popupMenu

    fun eventGoPopupMenu(){
        _popupMenu.value = true
    }
    fun eventGoPopupMenuFinished(){
        _popupMenu.value = false
    }


    class MealMealsViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
                LoginViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("MealMealsViewModel Not Found")
            }
        }
    }


}