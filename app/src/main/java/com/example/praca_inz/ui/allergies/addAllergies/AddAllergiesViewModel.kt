package com.example.praca_inz.ui.allergies.addAllergies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class AddAllergiesViewModel (app: Application) : AndroidViewModel(app)  {



    class AddAllergiesViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(AddAllergiesViewModel::class.java)) {
                AddAllergiesViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("AddAllergiesViewModel Not Found")
            }
        }
    }
}