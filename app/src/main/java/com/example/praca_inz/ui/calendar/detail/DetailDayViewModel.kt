package com.example.praca_inz.ui.calendar.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praca_inz.property.MyDayProperty
import com.example.praca_inz.property.MyFoodProperty

class DetailDayViewModel(myDayProperty: MyDayProperty, app: Application): AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<MyDayProperty>()

    val selectedProperty: LiveData<MyDayProperty>
        get() = _selectedProperty

    init {
        _selectedProperty.value = myDayProperty
    }
}