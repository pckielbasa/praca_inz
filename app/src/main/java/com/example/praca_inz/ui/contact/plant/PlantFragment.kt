package com.example.praca_inz.ui.contact.plant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.R
import com.example.praca_inz.databinding.FragmentPlantBinding
import com.example.praca_inz.databinding.MealFragmentBinding
import com.example.praca_inz.ui.food.meals.MealViewModel

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

        setHasOptionsMenu(true)
        return binding.root
    }

}