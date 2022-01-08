package com.example.praca_inz.ui.contact.chemistry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.R
import com.example.praca_inz.databinding.FragmentChemistryBinding
import com.example.praca_inz.databinding.FragmentPlantBinding
import com.example.praca_inz.ui.contact.plant.PlantViewModel

class ChemistryFragment : Fragment() {

    private val chemistryViewModel: ChemistryViewModel by lazy {
        ViewModelProvider(this)[ChemistryViewModel::class.java]
    }

    private lateinit var binding: FragmentChemistryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentChemistryBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.chemistryViewModel = chemistryViewModel

        setHasOptionsMenu(true)
        return binding.root
    }



}