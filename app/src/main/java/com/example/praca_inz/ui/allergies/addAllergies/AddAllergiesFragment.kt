package com.example.praca_inz.ui.allergies.addAllergies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.example.praca_inz.databinding.FragmentAddAllergiesBinding


class AddAllergiesFragment : Fragment() {

    private val addAllergiesViewModel: AddAllergiesViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, AddAllergiesViewModel.AddAllergiesViewModelFactory(activity.application))[AddAllergiesViewModel::class.java]
    }

    private lateinit var binding: FragmentAddAllergiesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddAllergiesBinding.inflate(inflater, container, false)
//        binding.lifecycleOwner = this
//        binding.addAllergiesViewModel = addAllergiesViewModel

        return binding.root
    }



}