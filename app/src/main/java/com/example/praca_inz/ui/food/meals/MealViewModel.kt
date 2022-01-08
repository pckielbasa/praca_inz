package com.example.praca_inz.ui.food.meals

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praca_inz.network.FoodApi
import com.example.praca_inz.property.ContactProperty
import com.example.praca_inz.property.FoodProperty
import com.example.praca_inz.ui.food.FoodGridAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealViewModel : ViewModel() {

    private val _status = MutableLiveData<FoodGridAdapter.FoodGridStatus>()

    val status: LiveData<FoodGridAdapter.FoodGridStatus>
        get() = _status

    private val _properties = MutableLiveData<List<FoodProperty>>()

    val properties: LiveData<List<FoodProperty>>
        get() = _properties


    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getMealRealEstateProperties()
    }

    private fun getMealRealEstateProperties(){
        coroutineScope.launch {
            val getPropertiesDeferred = FoodApi.retrofitService.getFoods()
            try {
                _status.value = FoodGridAdapter.FoodGridStatus.LOADING
                val listResult =  getPropertiesDeferred.await()
                _status.value = FoodGridAdapter.FoodGridStatus.DONE
                _properties.value = listResult
            } catch (e: Exception) {
                _status.value = FoodGridAdapter.FoodGridStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}