package com.example.praca_inz.ui.food.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.praca_inz.R
import com.example.praca_inz.databinding.DetailFoodFragmentBinding
import com.example.praca_inz.network.AllergiesApi
import com.example.praca_inz.network.RestApiService
import com.google.firebase.auth.FirebaseAuth


class DetailFoodFragment : Fragment() {
    private val detailFoodViewModel: DetailFoodViewModel by lazy {
        ViewModelProvider(this)[DetailFoodViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = DetailFoodFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val myFoodProperty = DetailFoodFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = DetailFoodViewModelFactory(myFoodProperty, application)
        binding.detailFoodViewModel = ViewModelProvider(
            this, viewModelFactory)[DetailFoodViewModel::class.java]

        detailFoodViewModel.goToFood.observe(viewLifecycleOwner, { goOpen ->
            if(goOpen){
                backToFood()
                detailFoodViewModel.foodFinish()
            }
        })


        binding.deleteFoodButton.setOnClickListener {
            val apiService = RestApiService()
            val username = FirebaseAuth.getInstance().currentUser!!.uid
            val foodId = detailFoodViewModel.selectedProperty.value!!._id
            apiService.deleteFood(foodId, username)
            val navController = NavHostFragment.findNavController(this)
            navController.navigate(R.id.action_detailFoodFragment_to_navigation_food)
        }

        binding.addAllergyButton.setOnClickListener {
            val allergy= false
            Log.i("allergy", allergy.toString())
            if (allergy){
                Toast.makeText(
                    this.context,
                    "This item exists in the allergy list.",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                openAllergyReport()
            }
        }
        return binding.root
    }

    private fun backToFood(){
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_detailFoodFragment_to_navigation_food)
    }

    private fun openAllergyReport(){
        val foodId = detailFoodViewModel.selectedProperty.value!!._id
        val type = detailFoodViewModel.selectedProperty.value!!.type
        val allergenName = detailFoodViewModel.selectedProperty.value!!.foodName
        val action = DetailFoodFragmentDirections.actionDetailFoodFragmentToReportAllergyFragment(foodId,"null", type, allergenName)
        Navigation.findNavController(requireView()).navigate(action)
    }
}