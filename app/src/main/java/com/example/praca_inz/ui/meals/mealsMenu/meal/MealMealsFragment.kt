package com.example.praca_inz.ui.meals.mealsMenu.meal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.R
import com.example.praca_inz.databinding.FragmentMealMealsBinding


class MealMealsFragment : Fragment() {

    private lateinit var binding: FragmentMealMealsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentMealMealsBinding.inflate(inflater, container, false)
      binding.lifecycleOwner = this
//      binding.loginViewModel = loginViewModel
      return binding.root
    }


}