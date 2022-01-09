package com.example.praca_inz.ui.contact

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.network.ContactApi
import com.example.praca_inz.property.ContactProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ContactViewModel (app: Application) : AndroidViewModel(app) {

    private val _eventOpenPopupMenu = MutableLiveData<Boolean>()
    val eventOpenPopupMenu : LiveData<Boolean>
        get() = _eventOpenPopupMenu

    fun openPopupMenu(){
        _eventOpenPopupMenu.value = true
    }
    fun openPopupMenuFinished(){
        _eventOpenPopupMenu.value = false
    }
    private val _status = MutableLiveData<ContactGridAdapter.ContactApiStatus>()

    val status: LiveData<ContactGridAdapter.ContactApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<ContactProperty>>()

    val properties: LiveData<List<ContactProperty>>
        get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getContactRealEstateProperties()
    }

    private fun getContactRealEstateProperties(){
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