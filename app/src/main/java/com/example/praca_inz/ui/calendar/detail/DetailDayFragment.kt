package com.example.praca_inz.ui.calendar.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.praca_inz.databinding.DetailDayFragmentBinding
import com.example.praca_inz.ui.food.detail.DetailFoodFragmentDirections

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

        //action_detailDayFragment_to_reportAllergyFragment
        return binding.root;
    }

//    private fun openAllergyReport(){
//        val foodId:String = detailDayViewModel.selectedProperty.value!!.itemId.toString()
//        val allergenName = detailDayViewModel.selectedProperty.value!!.itemName
//        val type = detailDayViewModel.selectedProperty.value!!.type
//        val action = DetailFoodFragmentDirections.actionDetailFoodFragmentToReportAllergyFragment(foodId,"null", type, allergenName)
//        Navigation.findNavController(requireView()).navigate(action)
//    }

}