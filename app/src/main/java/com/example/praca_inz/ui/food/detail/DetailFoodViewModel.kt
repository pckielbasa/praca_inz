package com.example.praca_inz.ui.food.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praca_inz.property.ContactProperty
import com.example.praca_inz.property.FoodProperty
import com.example.praca_inz.property.MyFoodProperty

class DetailFoodViewModel(myFoodProperty: MyFoodProperty, app:Application): AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<MyFoodProperty>()

    val selectedProperty: LiveData<MyFoodProperty>
        get() = _selectedProperty

    private val _eventOpenPopupMenu = MutableLiveData<Boolean>()
    val eventOpenPopupMenu : LiveData<Boolean>
        get() = _eventOpenPopupMenu

    fun openPopupMenu(){
        _eventOpenPopupMenu.value = true
    }
    fun openPopupMenuFinished(){
        _eventOpenPopupMenu.value = false
    }

    private val _eventDeleteFood = MutableLiveData<Boolean>()
    val eventDeleteFood : LiveData<Boolean>
        get() = _eventDeleteFood

    fun deleteFoodStart(){
        _eventDeleteFood.value = true
    }
    fun deleteFoodFinish(){
        _eventDeleteFood.value = false
    }

    init {
        _selectedProperty.value = myFoodProperty
    }


}