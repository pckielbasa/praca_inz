package com.example.praca_inz.ui.persons.addPerson

import android.app.Application
import androidx.lifecycle.*


class AddPersonViewModel(app: Application) : AndroidViewModel(app) {

    private val _goBackToPerson = MutableLiveData<Boolean>()
    val goBackToPerson : LiveData<Boolean>
        get() = _goBackToPerson

    fun goBackToPersonStart(){
        _goBackToPerson.value = true
    }
    fun goBackToPersonFinished(){
        _goBackToPerson.value = false
    }


    class AddPersonViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(AddPersonViewModel::class.java)) {
                AddPersonViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("LoginViewModel Not Found")
            }
        }
    }
}