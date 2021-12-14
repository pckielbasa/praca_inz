package com.example.praca_inz.ui.allergies.allergiesMenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.databinding.FragmentMealAllergiesBinding

class MealAllergiesFragment : Fragment() {

    private lateinit var binding: FragmentMealAllergiesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMealAllergiesBinding.inflate(inflater, container, false)

        return binding.root
    }


}