package com.example.praca_inz.ui.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praca_inz.network.UserApi
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

    private val _response = MutableLiveData<String>()
    val response:LiveData<String>
        get() = _response


    init {
        getMyDay()
    }

    private fun getMyDay(){
        val date = "12/10/2021"
        val username = FirebaseAuth.getInstance().currentUser!!.uid
        UserApi.retrofitService.getMyDayAsync(date, username).enqueue( object: Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }
        })
    }



}