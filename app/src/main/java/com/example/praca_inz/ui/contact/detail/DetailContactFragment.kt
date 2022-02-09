package com.example.praca_inz.ui.contact.detail

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
import com.example.praca_inz.databinding.DetailContactFragmentBinding
import com.example.praca_inz.network.RestApiService
import com.example.praca_inz.ui.food.detail.DetailFoodFragmentDirections
import com.google.firebase.auth.FirebaseAuth


class DetailContactFragment : Fragment() {
    private val detailContactViewModel: DetailContactViewModel by lazy {
        ViewModelProvider(this)[DetailContactViewModel::class.java]
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val application = requireNotNull(activity).application
        val binding = DetailContactFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val myContactProperty = DetailContactFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = DetailContactViewModelFactory(myContactProperty, application)
        binding.detailContactViewModel = ViewModelProvider(
            this, viewModelFactory)[DetailContactViewModel::class.java]

        detailContactViewModel.goToContact.observe(viewLifecycleOwner, { goOpen ->
            if(goOpen){
                backToContact()
                detailContactViewModel.contactFinish()
            }
        })

       binding.deleteContactButton.setOnClickListener {
           val apiService = RestApiService()
           val username = FirebaseAuth.getInstance().currentUser!!.uid
           val contactId = detailContactViewModel.selectedProperty.value!!._id
           apiService.deleteContact(contactId, username)
           val navController = NavHostFragment.findNavController(this)
           navController.navigate(R.id.action_detailContactFragment_to_navigation_contact)

       }

        binding.addAllergyButton.setOnClickListener {
            val allergy=detailContactViewModel.selectedProperty.value!!.allergy
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

    private fun backToContact(){
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_detailContactFragment_to_navigation_contact )
    }
    private fun openAllergyReport(){
        val contactId = detailContactViewModel.selectedProperty.value!!._id
        val type = detailContactViewModel.selectedProperty.value!!.type
        val allergenName = detailContactViewModel.selectedProperty.value!!.contactName
        val action = DetailContactFragmentDirections.actionDetailContactFragmentToReportAllergyFragment("null",contactId, type, allergenName)
        Navigation.findNavController(requireView()).navigate(action)

    }
}