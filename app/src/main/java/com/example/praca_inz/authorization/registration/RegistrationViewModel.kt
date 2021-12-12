package com.example.praca_inz.authorization.registration

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.authorization.login.LoginViewModel


class RegistrationViewModel(app: Application) : AndroidViewModel(app) {

    class RegistrationViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(RegistrationViewModel::class.java)) {
                RegistrationViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("LoginViewModel Not Found")
            }
        }
    }
}