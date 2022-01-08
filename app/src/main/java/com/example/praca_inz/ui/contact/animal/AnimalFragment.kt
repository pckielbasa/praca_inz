package com.example.praca_inz.ui.contact.animal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.R
import com.example.praca_inz.databinding.FragmentAnimalBinding
import com.example.praca_inz.databinding.FragmentChemistryBinding
import com.example.praca_inz.ui.contact.ContactGridAdapter
import com.example.praca_inz.ui.contact.chemistry.ChemistryViewModel


class AnimalFragment : Fragment() {


    private val animalViewModel: AnimalViewModel by lazy {
        ViewModelProvider(this)[AnimalViewModel::class.java]
    }

    private lateinit var binding: FragmentAnimalBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAnimalBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.animalViewModel = animalViewModel

        binding.componentsGrid.adapter = ContactGridAdapter()

        setHasOptionsMenu(true)
        return binding.root
    }

}