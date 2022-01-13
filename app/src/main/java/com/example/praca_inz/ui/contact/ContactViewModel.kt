package com.example.praca_inz.ui.contact

import android.annotation.SuppressLint
import androidx.lifecycle.*
import com.example.praca_inz.network.ContactApi
import com.example.praca_inz.network.ContactApiFilter
import com.example.praca_inz.property.ContactProperty
import com.example.praca_inz.ui.contact.ContactGridAdapter.*
import com.example.praca_inz.ui.food.FoodGridAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ContactViewModel : ViewModel() {

    private val _eventOpenPopupMenu = MutableLiveData<Boolean>()
    val eventOpenPopupMenu : LiveData<Boolean>
        get() = _eventOpenPopupMenu

    fun openPopupMenu(){
        _eventOpenPopupMenu.value = true
    }
    fun openPopupMenuFinished(){
        _eventOpenPopupMenu.value = false
    }
    private val _status = MutableLiveData<ContactApiStatus>()

    val status: LiveData<ContactApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<ContactProperty>>()

    val properties: LiveData<List<ContactProperty>>
        get() = _properties

    private val _navigateToSelectedProperty = MutableLiveData<ContactProperty>()

    val navigateToSelectedProperty: LiveData<ContactProperty>
        get() = _navigateToSelectedProperty

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getContactProperties(ContactApiFilter.SHOW_CHEMISTRY)
    }

    private fun getContactProperties(filter: ContactApiFilter){
        coroutineScope.launch {
            val getPropertiesDeferred = ContactApi.retrofitService.getContactsAsync(filter.type)
            try {
                _status.value = ContactApiStatus.LOADING
                val listResult =  getPropertiesDeferred.await()
                _status.value = ContactApiStatus.DONE
                _properties.value = listResult
                if (listResult.isEmpty()){
                    _status.value = ContactApiStatus.EMPTY
                }
            } catch (e: Exception) {
                _status.value = ContactApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun displayPropertyDetails(contactProperty: ContactProperty) {
        _navigateToSelectedProperty.value = contactProperty
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }

    fun updateFilter(filter: ContactApiFilter) {
        getContactProperties(filter)
    }


}