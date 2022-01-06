package com.example.praca_inz.ui.meals.mealsMenu.component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.databinding.FragmentComponentMealsBinding
import com.example.praca_inz.ui.meals.MealsViewModel


class ComponentMealsFragment : Fragment() {

    private lateinit var binding: FragmentComponentMealsBinding

    private val componentViewModel: ComponentViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, ComponentViewModel.ComponentViewModelFactory(activity.application))[ComponentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentComponentMealsBinding.inflate(inflater, container, false)
        binding.componentViewModel = componentViewModel



        setHasOptionsMenu(true)
        return binding.root
    }


}