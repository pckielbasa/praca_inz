package com.example.praca_inz.ui.profile

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.ui.persons.person.PersonViewModel

class ProfileViewModel (app: Application) : AndroidViewModel(app){

    private val _goLogout = MutableLiveData<Boolean>()
    val goLogout : LiveData<Boolean>
        get() = _goLogout

    fun goLogoutStart(){
        _goLogout.value = true
    }
    fun goLogoutFinished(){
        _goLogout.value = false
    }


    class ProfileViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
                ProfileViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("ProfileViewModel Not Found")
            }
        }
    }
}