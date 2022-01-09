package com.example.praca_inz.ui.contact.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praca_inz.property.ContactProperty

class DetailContactViewModel(contactProperty: ContactProperty, app:Application):AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<ContactProperty>()

    val selectedProperty: LiveData<ContactProperty>
        get() = _selectedProperty

    init {
        _selectedProperty.value = contactProperty
    }
}