package com.example.praca_inz.ui.allergies

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.authorization.login.LoginViewModel

class AllergiesViewModel (app: Application) : AndroidViewModel(app) {

    class AllergiesViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(AllergiesViewModel::class.java)) {
                AllergiesViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("AllergiesViewModel Not Found")
            }
        }
    }
}