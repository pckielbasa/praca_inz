package com.example.praca_inz.ui.contact

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praca_inz.network.ContactApiFilter
import com.example.praca_inz.network.UserApi
import com.example.praca_inz.property.MyContactProperty
import com.example.praca_inz.ui.contact.ContactGridAdapter.ContactApiStatus
import com.google.firebase.auth.FirebaseAuth
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

    private val _properties = MutableLiveData<List<MyContactProperty>>()

    val properties: LiveData<List<MyContactProperty>>
        get() = _properties

    private val _navigateToSelectedProperty = MutableLiveData<MyContactProperty>()

    val navigateToSelectedProperty: LiveData<MyContactProperty>
        get() = _navigateToSelectedProperty

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getContactProperties(ContactApiFilter.SHOW_CHEMISTRY)
    }

    private fun getContactProperties(filter: ContactApiFilter){
        coroutineScope.launch {
            val username = FirebaseAuth.getInstance().currentUser!!.uid
            val getPropertiesDeferred = UserApi.retrofitService.getMyContactsAsync(filter.type, username)
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

    fun displayPropertyDetails(myContactProperty: MyContactProperty) {
        _navigateToSelectedProperty.value = myContactProperty
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }

    fun updateFilter(filter: ContactApiFilter) {
        getContactProperties(filter)
    }


}