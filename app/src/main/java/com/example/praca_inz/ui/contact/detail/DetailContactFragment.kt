package com.example.praca_inz.ui.contact.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.databinding.DetailContactFragmentBinding


class DetailContactFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val application = requireNotNull(activity).application
        val binding = DetailContactFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val myContactProperty = DetailContactFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = DetailContactViewModelFactory(myContactProperty, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory)[DetailContactViewModel::class.java]
        return binding.root
    }


}