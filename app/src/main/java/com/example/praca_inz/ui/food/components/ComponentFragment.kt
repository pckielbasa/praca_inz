package com.example.praca_inz.ui.food.components

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.R
import com.example.praca_inz.databinding.ComponentFragmentBinding
import com.example.praca_inz.databinding.SnackFragmentBinding
import com.example.praca_inz.ui.food.snacks.SnackViewModel

class ComponentFragment : Fragment() {

    private val componentViewModel: ComponentViewModel by lazy {
        ViewModelProvider(this)[ComponentViewModel::class.java]
    }

    private lateinit var binding: ComponentFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ComponentFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.componentViewModel = componentViewModel

        setHasOptionsMenu(true)
        return binding.root
    }

}