package com.example.praca_inz.ui.calendar.selectFood

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.praca_inz.R
import com.example.praca_inz.databinding.SelectFoodFragmentBinding
import com.example.praca_inz.network.FoodApiFilter
import com.example.praca_inz.ui.food.FoodFragmentDirections
import com.example.praca_inz.ui.food.FoodGridAdapter
import com.example.praca_inz.ui.food.FoodViewModel

class SelectFoodFragment : Fragment() {


    private lateinit var  binding: SelectFoodFragmentBinding
    private val selectFoodViewModel: SelectFoodViewModel by lazy {
        ViewModelProvider(this)[SelectFoodViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = SelectFoodFragmentBinding.inflate(inflater)
       binding.lifecycleOwner = this
       binding.selectFoodViewModel = selectFoodViewModel


        selectFoodViewModel.goToAddFood.observe(viewLifecycleOwner, { goOpen ->
            if(goOpen){
                openAddFood()
                selectFoodViewModel.addFoodFinish()
            }
        })

        binding.selectFoodGrid.adapter = FoodGridAdapter(FoodGridAdapter.OnClickListener {
            selectFoodViewModel.displayPropertyDetails(it)
        })

        selectFoodViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(SelectFoodFragmentDirections.actionSelectFoodFragmentToAddFoodToDayFragment(it))
                selectFoodViewModel.displayPropertyDetailsComplete()
            }
        })
        binding.mealButton.setOnClickListener {
            selectFoodViewModel.updateFilter(
                FoodApiFilter.SHOW_MEAL
            )
        }
        binding.snackButton.setOnClickListener {
            selectFoodViewModel.updateFilter(
                FoodApiFilter.SHOW_SNACK

            )
        }
        binding.componentButton.setOnClickListener {
            selectFoodViewModel.updateFilter(
                FoodApiFilter.SHOW_COMPONENT

            )
        }

        return binding.root
    }

    private fun openAddFood(){
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_selectFoodFragment_to_addFoodFragment)
    }

}