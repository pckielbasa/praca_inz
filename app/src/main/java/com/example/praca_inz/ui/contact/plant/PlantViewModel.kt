package com.example.praca_inz.ui.contact.plant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praca_inz.network.ContactApi
import com.example.praca_inz.network.FoodApi
import com.example.praca_inz.property.ContactProperty
import com.example.praca_inz.property.FoodProperty
import com.example.praca_inz.ui.contact.ContactGridAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlantViewModel : ViewModel() {

    private val _status = MutableLiveData<ContactGridAdapter.ContactApiStatus>()

    val status: LiveData<ContactGridAdapter.ContactApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<ContactProperty>>()

    val properties: LiveData<List<ContactProperty>>
        get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getPlantRealEstateProperties()
    }

    private fun getPlantRealEstateProperties(){
        coroutineScope.launch {
            val getPropertiesDeferred = ContactApi.retrofitService.getContacts()
            try {
                _status.value = ContactGridAdapter.ContactApiStatus.LOADING
                val listResult =  getPropertiesDeferred.await()
                _status.value = ContactGridAdapter.ContactApiStatus.DONE
                _properties.value = listResult
            } catch (e: Exception) {
                _status.value = ContactGridAdapter.ContactApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}