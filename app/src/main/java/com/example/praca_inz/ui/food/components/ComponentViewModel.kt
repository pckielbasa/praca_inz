package com.example.praca_inz.ui.food.components

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praca_inz.network.ContactApi
import com.example.praca_inz.network.FoodApi
import com.example.praca_inz.property.ContactProperty
import com.example.praca_inz.property.FoodProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ComponentViewModel : ViewModel() {
    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _property = MutableLiveData<FoodProperty>()

    val property: LiveData<FoodProperty>
        get() = _property

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getComponentRealEstateProperties()
    }

    private fun getComponentRealEstateProperties(){
        coroutineScope.launch {
            val getPropertiesDeferred = FoodApi.retrofitService.getFoods()
            try {
                val listResult = getPropertiesDeferred.await()
                if (listResult.isNotEmpty()) {
                    _property.value = listResult[0]
                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}