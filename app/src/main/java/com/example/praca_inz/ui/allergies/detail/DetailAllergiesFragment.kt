package com.example.praca_inz.ui.allergies.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.praca_inz.R
import com.example.praca_inz.databinding.DetailAllergiesFragmentBinding
import com.example.praca_inz.network.RestApiService
import com.example.praca_inz.ui.food.detail.DetailFoodFragmentArgs
import com.example.praca_inz.ui.food.detail.DetailFoodViewModel
import com.example.praca_inz.ui.food.detail.DetailFoodViewModelFactory
import com.google.firebase.auth.FirebaseAuth

class DetailAllergiesFragment : Fragment() {

    private val detailAllergiesViewModel: DetailAllergiesViewModel by lazy {
        ViewModelProvider(this)[DetailAllergiesViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = DetailAllergiesFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val myAllergiesProperty = DetailAllergiesFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = DetailAllergiesViewModelFactory(myAllergiesProperty, application)
        binding.detailAllergiesViewModel = ViewModelProvider(
            this, viewModelFactory)[DetailAllergiesViewModel::class.java]

        detailAllergiesViewModel.goToAllergies.observe(viewLifecycleOwner, { goOpen ->
            if(goOpen){
               backToAllergies()
                detailAllergiesViewModel.allergiesFinish()
            }
        })

        binding.deleteAllergyButton.setOnClickListener {
            val apiService = RestApiService()
            val username = FirebaseAuth.getInstance().currentUser!!.uid
            val allergyId = detailAllergiesViewModel.selectedProperty.value!!._id
            apiService.deleteAllergy(allergyId, username)
            backToAllergies()
        }

        return binding.root
    }
    private fun backToAllergies(){
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_detailAllergiesFragment_to_navigation_allergies)
    }

}