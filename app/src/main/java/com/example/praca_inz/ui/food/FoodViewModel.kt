package com.example.praca_inz.ui.food

import android.annotation.SuppressLint
import androidx.lifecycle.*
import com.example.praca_inz.network.FoodApi
import com.example.praca_inz.network.FoodApiFilter
import com.example.praca_inz.network.UserFilter
import com.example.praca_inz.property.FoodProperty
import com.example.praca_inz.ui.food.FoodGridAdapter.*
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FoodViewModel : ViewModel(){
    private val _eventOpenPopupMenu = MutableLiveData<Boolean>()
    val eventOpenPopupMenu : LiveData<Boolean>
        get() = _eventOpenPopupMenu

    fun openPopupMenu(){
        _eventOpenPopupMenu.value = true
    }
    fun openPopupMenuFinished(){
        _eventOpenPopupMenu.value = false
    }

    private val _status = MutableLiveData<FoodGridStatus>()

    val status: LiveData<FoodGridStatus>
        get() = _status

    private val _properties = MutableLiveData<List<FoodProperty>>()

    val properties: LiveData<List<FoodProperty>>
        get() = _properties



    private val _navigateToSelectedProperty = MutableLiveData<FoodProperty>()

    val navigateToSelectedProperty: LiveData<FoodProperty>
        get() = _navigateToSelectedProperty

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getFoodProperties(FoodApiFilter.SHOW_MEAL, UserFilter.SHOW_USER)
    }

    private fun getFoodProperties(filter: FoodApiFilter, filterUser: UserFilter){
        coroutineScope.launch {
            val username = FirebaseAuth.getInstance().currentUser!!.uid
            val getPropertiesDeferred = FoodApi.retrofitService.getFoodsAsync(filter.type, username)
            try {
                _status.value = FoodGridStatus.LOADING
                val listResult =  getPropertiesDeferred.await()
                _status.value = FoodGridStatus.DONE
                _properties.value = listResult
                if (listResult.isEmpty()){
                    _status.value = FoodGridStatus.EMPTY
                }
            } catch (e: Exception) {
                _status.value = FoodGridStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


    fun displayPropertyDetails(foodProperty: FoodProperty) {
        _navigateToSelectedProperty.value = foodProperty
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
    fun updateFilter(filter: FoodApiFilter, filterUser: UserFilter) {
        getFoodProperties(filter, filterUser)
    }

}