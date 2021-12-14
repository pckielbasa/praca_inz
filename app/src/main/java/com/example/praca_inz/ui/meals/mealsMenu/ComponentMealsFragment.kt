package com.example.praca_inz.ui.meals.mealsMenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.databinding.FragmentComponentMealsBinding


class ComponentMealsFragment : Fragment() {

    private lateinit var binding: FragmentComponentMealsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComponentMealsBinding.inflate(inflater, container, false)
        return binding.root
    }


}