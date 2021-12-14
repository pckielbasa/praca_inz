package com.example.praca_inz.ui.meals.mealsMenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.R
import com.example.praca_inz.databinding.FragmentComponentMenuBinding
import com.example.praca_inz.databinding.FragmentMealsBinding


class ComponentMenuFragment : Fragment() {

    private lateinit var binding: FragmentComponentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComponentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }


}