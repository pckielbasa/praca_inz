package com.example.praca_inz.ui.calendar

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.data.Food
import com.example.praca_inz.network.FoodApiFilter
import com.example.praca_inz.network.UserApi
import com.example.praca_inz.network.UserFilter
import com.example.praca_inz.property.FoodProperty
import com.example.praca_inz.property.UserProperty
import com.example.praca_inz.ui.food.FoodGridAdapter
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CalendarViewModel:ViewModel() {

    enum class CalendarStatus { LOADING, ERROR, DONE,EMPTY }

    private val _openNavCalendar = MutableLiveData<Boolean>()
    val openNavCalendar : LiveData<Boolean>
        get() = _openNavCalendar

    fun openNavCalendarStart(){
        _openNavCalendar.value = true
    }

    fun openNavCalendarFinished(){
        _openNavCalendar.value = false


    }


    private val _status = MutableLiveData<CalendarStatus>()

    val status: LiveData<CalendarStatus>
        get() = _status

    private val _properties = MutableLiveData<UserProperty>()

    val properties: LiveData<UserProperty>
        get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getUserProperties(UserFilter.SHOW_USER)
    }


    private fun getUserProperties(filter: UserFilter){
        coroutineScope.launch {
            val username = FirebaseAuth.getInstance().currentUser!!.uid
            var getPropertiesDeferred = UserApi.retrofitService.getUserByUsernameAsync(username)
            try {
                _status.value = CalendarStatus.LOADING
                val listResult =  getPropertiesDeferred.await()
                _status.value = CalendarStatus.DONE
                _properties.value = listResult
                if (listResult != null){
                    _status.value = CalendarStatus.EMPTY
                }
            } catch (e: Exception) {
                _status.value = CalendarStatus.ERROR
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}