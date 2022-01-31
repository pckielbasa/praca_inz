package com.example.praca_inz.ui.food.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.R
import com.example.praca_inz.databinding.DetailFoodFragmentBinding
import com.example.praca_inz.ui.allergies.addAllergies.AddAllergiesFragment
import com.example.praca_inz.ui.food.FoodViewModel
import com.example.praca_inz.ui.food.addFood.AddFoodFragment

class DetailFoodFragment : Fragment() {

    private val detailFoodViewModel: DetailFoodViewModel by lazy {
        ViewModelProvider(this)[DetailFoodViewModel::class.java]
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val application = requireNotNull(activity).application
        val binding = DetailFoodFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val myFoodProperty = DetailFoodFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = DetailFoodViewModelFactory(myFoodProperty, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory)[DetailFoodViewModel::class.java]

        detailFoodViewModel.eventOpenPopupMenu.observe(viewLifecycleOwner, { goOpen ->
            if(goOpen){
                openAddAllergies()
                detailFoodViewModel.openPopupMenuFinished()
            }
        })


        return binding.root
    }
    private fun openAddAllergies(){
        val dialog = AddAllergiesFragment()
        dialog.show(requireActivity().supportFragmentManager, "ADD ALLERGIES THINGS")
    }
}