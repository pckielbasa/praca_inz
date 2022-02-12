package com.example.praca_inz.ui.calendar.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.praca_inz.R
import com.example.praca_inz.databinding.DetailDayFragmentBinding
import com.example.praca_inz.network.RestApiService
import com.example.praca_inz.ui.food.detail.DetailFoodFragmentDirections
import com.google.firebase.auth.FirebaseAuth

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

        detailDayViewModel.goToCalendar.observe(viewLifecycleOwner, { goOpen ->
            if(goOpen){
                backToCalendar()
                detailDayViewModel.backToCalendarFinish()
            }
        })

        binding.addAllergyButton.setOnClickListener {
            openAllergyReport()
        }

        binding.deleteItemButton.setOnClickListener {
            val apiService = RestApiService()
            val itemId = detailDayViewModel.selectedProperty.value!!._id
            val dayDate = detailDayViewModel.selectedProperty.value!!.dayDate
            apiService.deleteItemDay(itemId, dayDate)
            backToCalendar()
        }
        //action_detailDayFragment_to_reportAllergyFragment
        return binding.root;
    }

    private fun openAllergyReport(){
        val foodId = detailDayViewModel.selectedProperty.value!!.itemId
        val type = detailDayViewModel.selectedProperty.value!!.type
        val allergenName = detailDayViewModel.selectedProperty.value!!.itemName
        val action = DetailDayFragmentDirections.actionDetailDayFragmentToReportAllergyFragment(foodId,"null", type, allergenName)
        Navigation.findNavController(requireView()).navigate(action)
    }
private fun backToCalendar(){
    val navController = NavHostFragment.findNavController(this)
    navController.navigate(R.id.action_detailDayFragment_to_navigation_calendar)
}

}