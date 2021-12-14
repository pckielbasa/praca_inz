package com.example.praca_inz.ui.medicine.addMedicine

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.ui.persons.addPerson.AddPersonViewModel

class AddMedicineViewModel (app: Application) : AndroidViewModel(app){



    class AddMedicineViewModelFactory constructor(private val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(AddMedicineViewModel::class.java)) {
                AddMedicineViewModel(this.app) as T
            } else {
                throw IllegalArgumentException("AddMedicineViewModel Not Found")
            }
        }
    }
}