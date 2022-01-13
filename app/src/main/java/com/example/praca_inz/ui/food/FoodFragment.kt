package com.example.praca_inz.ui.food

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.praca_inz.R
import com.example.praca_inz.databinding.FragmentFoodBinding
import com.example.praca_inz.network.ContactApiFilter
import com.example.praca_inz.network.FoodApiFilter
import com.example.praca_inz.ui.food.addFood.AddFoodFragment


class FoodFragment : Fragment() {

    private lateinit var binding: FragmentFoodBinding
    private val foodViewModel: FoodViewModel by lazy {
        ViewModelProvider(this)[FoodViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.foodViewModel = foodViewModel

        //OPEN ADD MEAL
        foodViewModel.eventOpenPopupMenu.observe(viewLifecycleOwner, { goOpen ->
            if(goOpen){
                openAddContact()
                foodViewModel.openPopupMenuFinished()
            }
        })

        //OPEN LIST FROM DATABASE

        binding.foodGrid.adapter = FoodGridAdapter(FoodGridAdapter.OnClickListener {
            foodViewModel.displayPropertyDetails(it)
        })

        foodViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(FoodFragmentDirections.actionNavigationFoodToDetailFoodFragment(it))
                foodViewModel.displayPropertyDetailsComplete()
            }
        })
        binding.mealButton.setOnClickListener {
            foodViewModel.updateFilter(
                FoodApiFilter.SHOW_MEAL
            )
        }
        binding.snackButton.setOnClickListener {
            foodViewModel.updateFilter(
                FoodApiFilter.SHOW_SNACK
            )
        }
        binding.componentButton.setOnClickListener {
            foodViewModel.updateFilter(
                FoodApiFilter.SHOW_COMPONENT
            )
        }

        return binding.root
    }

    private fun openAddContact(){
        val dialog = AddFoodFragment()
        dialog.show(requireActivity().supportFragmentManager, "ADD CONTACT THINGS")
    }

}