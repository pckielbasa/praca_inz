package com.example.praca_inz.ui.calendar.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.praca_inz.property.MyDayProperty

class DetailDayViewModel(myDayProperty: MyDayProperty, app: Application): AndroidViewModel(app) {

    private val _goToCalendar = MutableLiveData<Boolean>()
    val goToCalendar : LiveData<Boolean>
        get() = _goToCalendar

    fun backToCalendar(){
        _goToCalendar.value = true
    }
    fun backToCalendarFinish(){
        _goToCalendar.value = false
    }

    private val _selectedProperty = MutableLiveData<MyDayProperty>()

    val selectedProperty: LiveData<MyDayProperty>
        get() = _selectedProperty

    init {
        _selectedProperty.value = myDayProperty
    }
}