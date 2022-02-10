package com.example.praca_inz.ui.allergies.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.property.MyAllergiesProperty


class DetailAllergiesViewModelFactory (
    private val myAllergiesProperty: MyAllergiesProperty,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailAllergiesViewModel::class.java)) {
            return DetailAllergiesViewModel(myAllergiesProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}