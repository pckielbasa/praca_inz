package com.example.praca_inz.ui.medicine.addMedicine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.R
import com.example.praca_inz.databinding.FragmentAddMedicineBinding
import com.example.praca_inz.databinding.FragmentAddPersonBinding
import com.example.praca_inz.ui.persons.addPerson.AddPersonViewModel

class AddMedicineFragment : Fragment() {

    private val addMedicineViewModel: AddMedicineViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, AddMedicineViewModel.AddMedicineViewModelFactory(activity.application)).get(
            AddMedicineViewModel::class.java)
    }

    private lateinit var binding: FragmentAddMedicineBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddMedicineBinding.inflate(inflater, container, false)
//        binding.lifecycleOwner = this
//        binding.addPersonViewModel = addPersonViewModel


        return binding.root
    }


}