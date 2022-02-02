package com.example.praca_inz.ui.food.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.praca_inz.R
import com.example.praca_inz.databinding.DetailFoodFragmentBinding
import com.example.praca_inz.network.RestApiService
import com.example.praca_inz.ui.allergies.addAllergies.AddAllergiesFragment
import com.google.firebase.auth.FirebaseAuth


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

        detailFoodViewModel.eventDeleteFood.observe(viewLifecycleOwner, { goDelete ->
            if(goDelete){
                val apiService = RestApiService()
                val username = FirebaseAuth.getInstance().currentUser!!.uid
                val foodName = detailFoodViewModel.selectedProperty.value!!.foodName
                apiService.deleteFood(foodName, username)
                val navController = NavHostFragment.findNavController(this)
                navController.navigate(R.id.action_detailFoodFragment_to_navigation_food)
                detailFoodViewModel.deleteFoodFinish()

            }
        })


        return binding.root
    }


    private fun openAddAllergies(){
        val dialog = AddAllergiesFragment()
        dialog.show(requireActivity().supportFragmentManager, "ADD ALLERGIES THINGS")
    }


}