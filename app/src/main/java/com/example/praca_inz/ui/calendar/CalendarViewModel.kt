package com.example.praca_inz.ui.calendar

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praca_inz.network.UserApi
import com.example.praca_inz.property.MyContactProperty
import com.example.praca_inz.property.MyDayProperty
import com.example.praca_inz.ui.contact.ContactGridAdapter
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


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

    private val _status = MutableLiveData<MyDayStatus>()
    val status: LiveData<MyDayStatus>
        get() = _status

    private val _properties = MutableLiveData<List<MyDayProperty>>()

    val properties: LiveData<List<MyDayProperty>>
        get() = _properties

    private val _navigateToSelectedProperty = MutableLiveData<MyDayProperty>()

    val navigateToSelectedProperty: LiveData<MyDayProperty>
        get() = _navigateToSelectedProperty


    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getMyDay()
    }

    private fun getMyDay() {
        val date = getCurrentDateTime()
        val dateInString = date.toString("dd/MM/yyyy")
        val username = FirebaseAuth.getInstance().currentUser!!.uid
        coroutineScope.launch {
            var getPropertiesDeferred = UserApi.retrofitService.getMyDayAsync(dateInString, username)
            try {
                _status.value = MyDayStatus.LOADING
                val listResult =  getPropertiesDeferred.await()
                _status.value = MyDayStatus.DONE
                _properties.value = listResult
                if (listResult.isEmpty()){
                    _status.value = MyDayStatus.EMPTY
                }
            } catch (e: Exception) {
                _status.value = MyDayStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun displayPropertyDetails(myDayProperty: MyDayProperty) {
        _navigateToSelectedProperty.value = myDayProperty
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }

    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }
    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

}