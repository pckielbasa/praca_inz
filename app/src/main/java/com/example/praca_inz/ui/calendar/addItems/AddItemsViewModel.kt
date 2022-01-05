package com.example.praca_inz.ui.calendar.addItems

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.authorization.login.LoginViewModel

class AddItemsViewModel (app: Application) : AndroidViewModel(app){

    private val _closeAddItem = MutableLiveData<Boolean>()
    val closeAddItem : LiveData<Boolean>
        get() = _closeAddItem

    fun closeAddItem(){
        _closeAddItem.value = true
    }

    fun closeAddItemFinished(){
        _closeAddItem.value = false
    }

    class AddItemsViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(AddItemsViewModel::class.java)) {
                AddItemsViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("AddItemsViewModel Not Found")
            }
        }
    }
}