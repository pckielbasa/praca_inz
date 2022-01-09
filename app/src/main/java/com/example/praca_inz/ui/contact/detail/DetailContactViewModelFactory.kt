package com.example.praca_inz.ui.contact.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.property.ContactProperty


class DetailContactViewModelFactory (
    private val contactProperty: ContactProperty,
    private val application: Application) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetailContactViewModel::class.java)) {
                return DetailContactViewModel(contactProperty, application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}