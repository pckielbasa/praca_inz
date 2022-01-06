package com.example.praca_inz.ui.meals.mealsMenu.component

import android.app.Application

import androidx.lifecycle.*
import com.example.praca_inz.network.FoodApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ComponentViewModel (app: Application) : AndroidViewModel(app) {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getComponentText()
    }

    private fun getComponentText(){
        FoodApi.retrofitService.getProperties().enqueue( object: Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }
        })

    }

    class ComponentViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(ComponentViewModel::class.java)) {
                ComponentViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("ComponentViewModel Not Found")
            }
        }
    }
}