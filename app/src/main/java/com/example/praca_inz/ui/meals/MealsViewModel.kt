package com.example.praca_inz.ui.meals

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.ui.persons.addPerson.AddPersonViewModel

class MealsViewModel (app: Application) : AndroidViewModel(app) {

    private val _eventOpenPopupMenu = MutableLiveData<Boolean>()
    val eventOpenPopupMenu : LiveData<Boolean>
        get() = _eventOpenPopupMenu

    fun openPopupMenu(){
        _eventOpenPopupMenu.value = true
    }
    fun openPopupMenuFinished(){
        _eventOpenPopupMenu.value = false
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