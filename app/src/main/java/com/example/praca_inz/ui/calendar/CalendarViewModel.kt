package com.example.praca_inz.ui.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praca_inz.network.UserApi
import com.example.praca_inz.property.MyDayProperty
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await


class CalendarViewModel:ViewModel() {

    enum class MyDayStatus { LOADING, ERROR, DONE,EMPTY }

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

    private val _properties = MutableLiveData<List<MyDayProperty>>()

    val properties: LiveData<List<MyDayProperty>>
        get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getMyDay()
    }

    private fun getMyDay() {
        val date = "12/11/2021"
        val username = FirebaseAuth.getInstance().currentUser!!.uid
        coroutineScope.launch {
            var getPropertiesDeferred = UserApi.retrofitService.getMyDayAsync(date, username)
            try {
                var listResult = getPropertiesDeferred.await()
                if (listResult.isNotEmpty()) {
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