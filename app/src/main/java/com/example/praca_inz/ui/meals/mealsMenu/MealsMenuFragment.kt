package com.example.praca_inz.ui.meals.mealsMenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.R
import com.example.praca_inz.databinding.FragmentMealsMenuBinding


class MealsMenuFragment : Fragment() {

    private lateinit var binding: FragmentMealsMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentMealsMenuBinding.inflate(inflater, container, false)
        return binding.root
    }


}