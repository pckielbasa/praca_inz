package com.example.praca_inz.ui.meals.mealsMenu.meal

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.authorization.login.LoginViewModel
import com.example.praca_inz.network.MealApi
import com.example.praca_inz.network.MealProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MealMealsViewModel  : ViewModel() {

    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _properties = MutableLiveData<List<MealProperty>>()

    val properties: LiveData<List<MealProperty>>
        get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getUser()
    }

    private fun getUser(){
        coroutineScope.launch{
            var getPropertiesDeferred = MealApi.retrofitService.getProperties()
            try {
                var listResult = getPropertiesDeferred.await()
                if (listResult.size>0) {
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