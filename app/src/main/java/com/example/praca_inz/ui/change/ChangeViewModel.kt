package com.example.praca_inz.ui.change

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praca_inz.R

class ChangeViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {

    }
    val text: LiveData<String> = _text
}