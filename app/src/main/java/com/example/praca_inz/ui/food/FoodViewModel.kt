package com.example.praca_inz.ui.food

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.ui.contact.ContactViewModel

class FoodViewModel  (app: Application) : AndroidViewModel(app){
    private val _eventOpenPopupMenu = MutableLiveData<Boolean>()
    val eventOpenPopupMenu : LiveData<Boolean>
        get() = _eventOpenPopupMenu

    fun openPopupMenu(){
        _eventOpenPopupMenu.value = true
    }
    fun openPopupMenuFinished(){
        _eventOpenPopupMenu.value = false
    }

    class FoodViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(FoodViewModel::class.java)) {
                FoodViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("FoodViewModel Not Found")
            }
        }
    }
}