package com.example.praca_inz.ui.persons.person

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.authorization.login.LoginViewModel

class PersonViewModel (app: Application) : AndroidViewModel(app) {

    private val _goAddPerson = MutableLiveData<Boolean>()
    val goAddPerson : LiveData<Boolean>
        get() = _goAddPerson

    private val _goEditPerson = MutableLiveData<Boolean>()
    val goEditPerson : LiveData<Boolean>
        get() = _goEditPerson

    fun goAddPersonStart(){
        _goAddPerson.value = true
    }
    fun goAddPersonFinished(){
        _goAddPerson.value = false
    }

    fun goEditPersonStart(){
        _goEditPerson.value = true
    }
    fun goEditPersonFinished(){
        _goEditPerson.value = false
    }

    class PersonViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(PersonViewModel::class.java)) {
                PersonViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("PersonViewModel Not Found")
            }
        }
    }
}