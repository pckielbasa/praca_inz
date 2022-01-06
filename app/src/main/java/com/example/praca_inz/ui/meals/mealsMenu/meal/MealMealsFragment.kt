package com.example.praca_inz.ui.meals.mealsMenu.meal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.databinding.FragmentMealMealsBinding



class MealMealsFragment : Fragment() {

    private val mealMealsViewModel: MealMealsViewModel by lazy {
        ViewModelProvider(this) [MealMealsViewModel::class.java]
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      val binding = FragmentMealMealsBinding.inflate(inflater)
      binding.lifecycleOwner = this
      binding.mealMealsViewModel =mealMealsViewModel

        binding.photosGrid.adapter = MealAdapter()

      return binding.root
    }


}