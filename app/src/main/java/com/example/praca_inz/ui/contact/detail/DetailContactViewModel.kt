package com.example.praca_inz.ui.contact.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praca_inz.property.ContactProperty
import com.example.praca_inz.property.MyContactProperty

class DetailContactViewModel(myContactProperty: MyContactProperty, app:Application):AndroidViewModel(app) {

    private val _goToContact = MutableLiveData<Boolean>()
    val goToContact : LiveData<Boolean>
        get() = _goToContact

    fun contactStart(){
        _goToContact.value = true
    }
    fun contactFinish(){
        _goToContact.value = false
    }

    private val _selectedProperty = MutableLiveData<MyContactProperty>()
    val selectedProperty: LiveData<MyContactProperty>
        get() = _selectedProperty


    init {
        _selectedProperty.value = myContactProperty
    }
}