package com.example.praca_inz.ui.food.snacks

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.R
import com.example.praca_inz.databinding.MealFragmentBinding
import com.example.praca_inz.databinding.SnackFragmentBinding
import com.example.praca_inz.ui.food.meals.MealViewModel

class SnackFragment : Fragment() {

    private val snackViewModel: SnackViewModel by lazy {
        ViewModelProvider(this)[SnackViewModel::class.java]
    }

    private lateinit var binding: SnackFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = SnackFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.snackViewModel = snackViewModel

        setHasOptionsMenu(true)
        return binding.root
    }
}