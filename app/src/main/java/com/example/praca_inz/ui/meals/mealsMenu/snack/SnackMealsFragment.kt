package com.example.praca_inz.ui.meals.mealsMenu.snack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.R
import com.example.praca_inz.databinding.FragmentSnackMealsBinding

class SnackMealsFragment : Fragment() {

    private lateinit var binding: FragmentSnackMealsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSnackMealsBinding.inflate(inflater,container,false)

        return binding.root


    }


}