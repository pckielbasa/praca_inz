package com.example.praca_inz.ui.persons.person

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.authorization.login.LoginViewModel
import com.example.praca_inz.network.FoodApi
import com.example.praca_inz.network.PersonApi
import com.example.praca_inz.property.PersonProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PersonViewModel (app: Application) : AndroidViewModel(app) {

    class PersonViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(PersonViewModel::class.java)) {
                PersonViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("PersonViewModel Not Found")
            }
        }
    }

    private val _goAddPerson = MutableLiveData<Boolean>()
    val goAddPerson : LiveData<Boolean>
        get() = _goAddPerson

    private val _goEditPerson = MutableLiveData<Boolean>()
    val goEditPerson : LiveData<Boolean>
        get() = _goEditPerson

    fun goAddPersonStart(){
        _goAddPerson.value = true
    }
    fun goAddPersonFinished(){
        _goAddPerson.value = false
    }

    fun goEditPersonStart(){
        _goEditPerson.value = true
    }
    fun goEditPersonFinished(){
        _goEditPerson.value = false
    }

//Connection with database

    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _properties = MutableLiveData<List<PersonProperty>>()

    val properties: LiveData<List<PersonProperty>>
        get() = _properties
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getPersonText()
    }

    private fun getPersonText(){
        coroutineScope.launch {   var getPropertiesDeferred = PersonApi.retrofitService.getProperties()
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