package com.example.praca_inz.ui.allergies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllergiesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is allergies Fragment"
    }
    val text: LiveData<String> = _text
}