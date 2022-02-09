package com.example.praca_inz.ui.calendar.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.property.MyDayProperty

class DetailDayViewModelFactory (
    private val myDayProperty: MyDayProperty,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailDayViewModel::class.java)) {
            return DetailDayViewModel(myDayProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}