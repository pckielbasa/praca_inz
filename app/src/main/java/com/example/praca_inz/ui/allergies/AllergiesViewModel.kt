package com.example.praca_inz.ui.allergies

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praca_inz.network.AllergiesApiFilter
import com.example.praca_inz.network.UserApi
import com.example.praca_inz.property.MyAllergiesProperty
import com.example.praca_inz.ui.allergies.AllergiesGridAdapter.*
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.await

class AllergiesViewModel : ViewModel() {
    private val _status = MutableLiveData<AllergiesGridStatus>()

    val status: LiveData<AllergiesGridStatus>
        get() = _status

    private val _properties = MutableLiveData<List<MyAllergiesProperty>>()

    val properties: LiveData<List<MyAllergiesProperty>>
        get() = _properties



    private val _navigateToSelectedProperty = MutableLiveData<MyAllergiesProperty>()

    val navigateToSelectedProperty: LiveData<MyAllergiesProperty>
        get() = _navigateToSelectedProperty

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getAllergiesProperties(AllergiesApiFilter.SHOW_MEAL)
    }

    private fun getAllergiesProperties(filter: AllergiesApiFilter){
        coroutineScope.launch {
            val username = FirebaseAuth.getInstance().currentUser!!.uid
            Log.i("retrofit", username)
            val getPropertiesDeferred = UserApi.retrofitService.getMyAllergiesAsync(filter.type, username)
            try {
                _status.value = AllergiesGridStatus.LOADING
                filter.type
                val listResult =  getPropertiesDeferred.await()
                _status.value = AllergiesGridStatus.DONE
                _properties.value = listResult
                if (listResult.isEmpty()){
                    _status.value = AllergiesGridStatus.EMPTY
                }
            } catch (e: Exception) {
                _status.value = AllergiesGridStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun displayPropertyDetails(myAllergiesProperty: MyAllergiesProperty) {
        _navigateToSelectedProperty.value = myAllergiesProperty
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
    fun updateFilter(filter: AllergiesApiFilter) {
        getAllergiesProperties(filter)
    }

}