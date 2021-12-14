package com.example.praca_inz.ui.medicine

import android.app.Application
import androidx.lifecycle.*
import com.example.praca_inz.ui.persons.person.PersonViewModel

class MedicineViewModel  (app: Application) : AndroidViewModel(app) {

    class MedicineViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(MedicineViewModel::class.java)) {
                MedicineViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("MedicineViewModel Not Found")
            }
        }
    }
}