package com.example.praca_inz.ui.calendar

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.network.UserApi
import com.example.praca_inz.property.UserProperty
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CalendarViewModel:ViewModel() {

    private val _openNavCalendar = MutableLiveData<Boolean>()
    val openNavCalendar : LiveData<Boolean>
        get() = _openNavCalendar

    fun openNavCalendarStart(){
        _openNavCalendar.value = true
    }

    fun openNavCalendarFinished(){
        _openNavCalendar.value = false


    }


    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _properties = MutableLiveData<List<UserProperty>>()

    val properties: LiveData<List<UserProperty>>
        get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getUserProperties()
    }


    private fun getUserProperties(){
        coroutineScope.launch {
            var getPropertiesDeferred = UserApi.retrofitService.getUserByUsernameAsync()
            try {
                var listResult = getPropertiesDeferred.await()
                if (listResult.size > 0) {
                    _properties.value = listResult
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