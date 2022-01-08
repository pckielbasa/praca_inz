package com.example.praca_inz.ui.food.meals

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.databinding.MealFragmentBinding
import com.example.praca_inz.ui.food.FoodGridAdapter

class MealFragment : Fragment() {

    private val mealViewModel: MealViewModel by lazy {
        ViewModelProvider(this)[MealViewModel::class.java]
    }

    private lateinit var binding:MealFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = MealFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.mealViewModel = mealViewModel

        binding.componentsGrid.adapter = FoodGridAdapter()

        setHasOptionsMenu(true)
        return binding.root
    }



}