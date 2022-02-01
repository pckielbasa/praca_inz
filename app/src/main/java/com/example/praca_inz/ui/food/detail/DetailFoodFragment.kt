package com.example.praca_inz.ui.food.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.praca_inz.R
import com.example.praca_inz.data.Food
import com.example.praca_inz.databinding.DetailFoodFragmentBinding
import com.example.praca_inz.network.*
import com.example.praca_inz.ui.allergies.addAllergies.AddAllergiesFragment
import com.example.praca_inz.ui.contact.ContactFragmentDirections
import com.example.praca_inz.ui.food.FoodViewModel
import com.example.praca_inz.ui.food.addFood.AddFoodFragment
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response









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
                deleteFood()
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

    private fun deleteFood(){
        val username = FirebaseAuth.getInstance().currentUser!!.uid
        val foodName = detailFoodViewModel.selectedProperty.value!!.foodName
        val deleteRequest: Call<Void?>? = FoodApi.retrofitService.deleteFood(foodName,username)
        deleteRequest!!.enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                Toast.makeText(
                    context,
                    "Deleted $foodName successful",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onFailure(call: Call<Void?>, t: Throwable) {
                Toast.makeText(
                    context,
                    "Deleted $foodName fault!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

}