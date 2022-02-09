package com.example.praca_inz.ui.contact.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddContactViewModel : ViewModel() {
    private val _goToContact = MutableLiveData<Boolean>()
    val goToContact : LiveData<Boolean>
        get() = _goToContact

    fun contactStart(){
        _goToContact.value = true
    }
    fun contactFinish(){
        _goToContact.value = false
    }
}