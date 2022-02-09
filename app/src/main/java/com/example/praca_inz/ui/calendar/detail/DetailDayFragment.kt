package com.example.praca_inz.ui.calendar.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.R
import com.example.praca_inz.databinding.DetailDayFragmentBinding

class DetailDayFragment : Fragment() {

    private val detailDayViewModel: DetailDayViewModel by lazy {
        ViewModelProvider(this)[DetailDayViewModel::class.java]
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(activity).application
        val binding = DetailDayFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val myDayProperty = DetailDayFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = DetailDayViewModelFactory(myDayProperty, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory)[DetailDayViewModel::class.java]
        return binding.root;
    }

}