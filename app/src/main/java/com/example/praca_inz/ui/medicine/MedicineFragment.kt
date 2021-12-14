package com.example.praca_inz.ui.medicine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.databinding.FragmentAddPersonBinding
import com.example.praca_inz.databinding.FragmentMedicineBinding
import com.example.praca_inz.ui.persons.addPerson.AddPersonViewModel

class MedicineFragment : Fragment() {

    private val medicineViewModel: MedicineViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, MedicineViewModel.MedicineViewModelFactory(activity.application)).get(
            MedicineViewModel::class.java)
    }

    private lateinit var binding: FragmentMedicineBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMedicineBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.medicineViewModel = medicineViewModel

        return binding.root
    }

}