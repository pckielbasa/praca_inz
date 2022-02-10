package com.example.praca_inz.authorization.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LoginViewModel (app: Application) : AndroidViewModel(app) {




    class LoginViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
                LoginViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("LoginViewModel Not Found")
            }
        }
    }


}