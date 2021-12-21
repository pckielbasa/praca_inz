package com.example.praca_inz.ui.contact

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.ui.meals.MealsViewModel

class ContactViewModel (app: Application) : AndroidViewModel(app) {

    private val _eventOpenPopupMenu = MutableLiveData<Boolean>()
    val eventOpenPopupMenu : LiveData<Boolean>
        get() = _eventOpenPopupMenu

    fun openPopupMenu(){
        _eventOpenPopupMenu.value = true
    }
    fun openPopupMenuFinished(){
        _eventOpenPopupMenu.value = false
    }
    class ContactViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
                ContactViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("ContactViewModel Not Found")
            }
        }
    }
}