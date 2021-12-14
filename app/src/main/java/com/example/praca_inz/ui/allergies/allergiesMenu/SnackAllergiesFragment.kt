package com.example.praca_inz.ui.allergies.allergiesMenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.R
import com.example.praca_inz.databinding.FragmentAllergiesBinding
import com.example.praca_inz.databinding.FragmentSnackAllergiesBinding

class SnackAllergiesFragment : Fragment() {

    private lateinit var binding: FragmentSnackAllergiesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSnackAllergiesBinding.inflate(inflater, container, false)

        return binding.root
    }


}