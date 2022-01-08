package com.example.praca_inz.ui.contact.plant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.databinding.FragmentPlantBinding
import com.example.praca_inz.ui.contact.ContactGridAdapter

class PlantFragment : Fragment() {

    private val plantViewModel: PlantViewModel by lazy {
        ViewModelProvider(this)[PlantViewModel::class.java]
    }

    private lateinit var binding: FragmentPlantBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPlantBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.plantViewModel = plantViewModel

        binding.componentsGrid.adapter = ContactGridAdapter()

        setHasOptionsMenu(true)
        return binding.root
    }

}