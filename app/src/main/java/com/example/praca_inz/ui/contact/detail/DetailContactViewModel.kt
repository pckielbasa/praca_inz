package com.example.praca_inz.ui.contact.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praca_inz.property.ContactProperty
import com.example.praca_inz.property.MyContactProperty

class DetailContactViewModel(myContactProperty: MyContactProperty, app:Application):AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<MyContactProperty>()

    val selectedProperty: LiveData<MyContactProperty>
        get() = _selectedProperty

    init {
        _selectedProperty.value = myContactProperty
    }
}