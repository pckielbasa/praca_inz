package com.example.praca_inz.ui.contact.chemistry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praca_inz.network.ContactApi
import com.example.praca_inz.property.ContactProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChemistryViewModel  : ViewModel() {

    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _property = MutableLiveData<ContactProperty>()

    val property: LiveData<ContactProperty>
        get() = _property

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getChemistryRealEstateProperties()
    }

    private fun getChemistryRealEstateProperties(){
        coroutineScope.launch {
            val getPropertiesDeferred = ContactApi.retrofitService.getContacts()
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