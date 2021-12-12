package com.example.praca_inz.ui.meals

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MealsViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Meals Fragment"
    }
    val text: LiveData<String> = _text
}