package com.example.praca_inz.ui.food.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.R
import com.example.praca_inz.databinding.DetailFoodFragmentBinding

class DetailFoodFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val application = requireNotNull(activity).application
        val binding = DetailFoodFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val foodProperty = DetailFoodFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = DetailFoodViewModelFactory(foodProperty, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory)[DetailFoodViewModel::class.java]
        return binding.root
    }

}