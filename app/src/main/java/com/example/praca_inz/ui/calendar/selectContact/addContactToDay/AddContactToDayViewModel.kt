package com.example.praca_inz.ui.calendar.selectContact.addContactToDay

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.praca_inz.property.MyContactProperty

class AddContactToDayViewModel (myContactProperty: MyContactProperty,
                                app: Application): AndroidViewModel(app) {
    private val _goToSelectContact = MutableLiveData<Boolean>()
    val goToSelectContact : LiveData<Boolean>
        get() = _goToSelectContact

    fun selectContactStart(){
        _goToSelectContact.value = true
    }
    fun selectContactFinish(){
        _goToSelectContact.value = false
    }

    private val _selectedProperty = MutableLiveData<MyContactProperty>()
    val selectedProperty: LiveData<MyContactProperty>
        get() = _selectedProperty


    init {
        _selectedProperty.value = myContactProperty
    }

}