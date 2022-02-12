package com.example.praca_inz.ui.calendar.selectContact.addContactToDay

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.property.MyContactProperty


class AddContactToDarViewModelFactory  (
    private val myContactProperty: MyContactProperty,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddContactToDayViewModel::class.java)) {
            return AddContactToDayViewModel(myContactProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}