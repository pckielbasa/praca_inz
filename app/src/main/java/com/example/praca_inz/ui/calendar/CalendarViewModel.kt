package com.example.praca_inz.ui.calendar

import android.app.Application
import androidx.lifecycle.*


class CalendarViewModel (app: Application) : AndroidViewModel(app) {

    private val _openNavCalendar = MutableLiveData<Boolean>()
    val openNavCalendar : LiveData<Boolean>
        get() = _openNavCalendar

    fun openNavCalendarStart(){
        _openNavCalendar.value = true
    }

    fun openNavCalendarFinished(){
        _openNavCalendar.value = false


    }



    class CalendarViewModelFactory constructor(private val app: Application ): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(CalendarViewModel::class.java)) {
                CalendarViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("CalendarViewModel Not Found")
            }
        }
    }
}