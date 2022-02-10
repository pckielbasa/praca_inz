package com.example.praca_inz.ui.allergies.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.praca_inz.property.MyAllergiesProperty

class DetailAllergiesViewModel (myAllergiesProperty: MyAllergiesProperty, app: Application): AndroidViewModel(app) {


    private val _goToAllergies = MutableLiveData<Boolean>()
    val goToAllergies : LiveData<Boolean>
        get() = _goToAllergies

    fun allergiesStart(){
        _goToAllergies.value = true
    }
    fun allergiesFinish(){
        _goToAllergies.value = false
    }

    private val _selectedProperty = MutableLiveData<MyAllergiesProperty>()
    val selectedProperty: LiveData<MyAllergiesProperty>
        get() = _selectedProperty


    init {
        _selectedProperty.value = myAllergiesProperty
    }
}