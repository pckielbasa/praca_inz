package com.example.praca_inz.ui.persons.person

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.authorization.login.LoginViewModel
import com.example.praca_inz.network.FoodApi
import com.example.praca_inz.network.PersonApi
import com.example.praca_inz.property.PersonProperty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonViewModel (app: Application) : AndroidViewModel(app) {

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


    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getPersonText()
    }

    private fun getPersonText(){
        PersonApi.retrofitService.getProperties().enqueue( object: Callback<List<PersonProperty>> {
            override fun onFailure(call: Call<List<PersonProperty>>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<List<PersonProperty>>, response: Response<List<PersonProperty>>) {
                _response.value = "Success: ${response.body()?.size} Mars properties retrieved"

            }
        })

    }


    class PersonViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(PersonViewModel::class.java)) {
                PersonViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("PersonViewModel Not Found")
            }
        }
    }
}