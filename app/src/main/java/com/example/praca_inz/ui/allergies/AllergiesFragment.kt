package com.example.praca_inz.ui.allergies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.praca_inz.databinding.FragmentAllergiesBinding
import com.example.praca_inz.network.AllergiesApiFilter

class AllergiesFragment : Fragment() {

    private lateinit var binding: FragmentAllergiesBinding
    private val allergiesViewModel: AllergiesViewModel by lazy {
        ViewModelProvider(this)[AllergiesViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllergiesBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.allergiesViewModel = allergiesViewModel

        binding.allergiesGrid.adapter = AllergiesGridAdapter(AllergiesGridAdapter.OnClickListener {
            allergiesViewModel.displayPropertyDetails(it)
        })

        allergiesViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(AllergiesFragmentDirections.actionNavigationAllergiesToDetailAllergiesFragment(it))
                allergiesViewModel.displayPropertyDetailsComplete()
            }
        })

        binding.mealButton.setOnClickListener {
            allergiesViewModel.updateFilter(
                AllergiesApiFilter.SHOW_MEAL
            )
        }
        binding.snackButton.setOnClickListener {
            allergiesViewModel.updateFilter(
                AllergiesApiFilter.SHOW_SNACK

            )
        }
        binding.componentButton.setOnClickListener {
            allergiesViewModel.updateFilter(
                AllergiesApiFilter.SHOW_COMPONENT

            )
        }
        binding.animalButton.setOnClickListener {
            allergiesViewModel.updateFilter(
                AllergiesApiFilter.SHOW_ANIMAL,
            )
        }
        binding.chemistryButton.setOnClickListener {
            allergiesViewModel.updateFilter(
                AllergiesApiFilter.SHOW_CHEMISTRY,
            )
        }
        binding.plantButton.setOnClickListener {
            allergiesViewModel.updateFilter(
                AllergiesApiFilter.SHOW_PLANT,
            )
        }

        return binding.root
    }



}