package com.example.praca_inz.ui.profile

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.network.FoodApi
import com.example.praca_inz.network.UserApi
import com.example.praca_inz.property.UserProperty
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProfileViewModel (app: Application) : AndroidViewModel(app){

    private val _goLogout = MutableLiveData<Boolean>()
    val goLogout : LiveData<Boolean>
        get() = _goLogout

    fun goLogoutStart(){
        _goLogout.value = true
    }
    fun goLogoutFinished(){
        _goLogout.value = false
    }
    private val _email  = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email

    private val _name  = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    private val _surname  = MutableLiveData<String>()
    val surname: LiveData<String>
        get() = _surname

    private val _phone  = MutableLiveData<String>()
    val phone: LiveData<String>
        get() = _phone

    init {
        getUser()
    }
    private fun getUser(){
        val email = FirebaseAuth.getInstance().currentUser!!.email.toString()
        UserApi.retrofitService.getUserByEmail(email).enqueue( object: Callback<UserProperty> {
            override fun onFailure(call: Call<UserProperty>, t: Throwable) {
                _email.value = "Failure: " + t.message
                _name.value = "Failure" +t.message
                _surname.value = "Failure" +t.message
                _phone.value = "Failure" +t.message
            }

            override fun onResponse(call: Call<UserProperty>, response: Response<UserProperty>) {
                _email.value = response.body()?.email.toString()
                _name.value = response.body()?.name.toString()
                _surname.value = response.body()?.surname.toString()
                _phone.value = response.body()?.phoneNumber.toString()

            }
        })
    }


}