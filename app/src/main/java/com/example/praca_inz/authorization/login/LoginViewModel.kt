package com.example.praca_inz.authorization.login

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.ui.calendar.CalendarViewModel

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