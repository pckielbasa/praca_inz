package com.example.praca_inz.ui.calendar.selectFood.addFoodToDay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.praca_inz.R
import com.example.praca_inz.databinding.AddFoodToDayFragmentBinding
import java.util.*

class AddFoodToDayFragment : Fragment() {

    private lateinit var binding:AddFoodToDayFragmentBinding
    private val addFoodToDayViewModel: AddFoodToDayViewModel by lazy {
        ViewModelProvider(this)[AddFoodToDayViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        binding = AddFoodToDayFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val myFoodProperty = AddFoodToDayFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = AddFoodToDayViewModelFactory(myFoodProperty, application)
        binding.addFoodToDayViewModel = ViewModelProvider(
            this, viewModelFactory)[AddFoodToDayViewModel::class.java]

        setLocalTime()

        addFoodToDayViewModel.goToSelectFood.observe(viewLifecycleOwner, { goOpen ->
            if(goOpen){
                backToFood()
                addFoodToDayViewModel.selectFoodFinish()
            }
        })


       return binding.root
    }

    private fun backToFood(){
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_addFoodToDayFragment_to_navigation_calendar)
    }
    private fun setLocalTime(){
        val timeZone = TimeZone.getTimeZone("Poland")
        TimeZone.setDefault(timeZone)
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val time = if (hour<10 && minute < 10){
            "0$hour : 0$minute"
        }else if (hour<10 && minute >= 10){
            "0$hour : $minute"
        }else if(hour>=10 && minute <10){
            "$hour : 0$minute"
        }else{
            "$hour : $minute"
        }
        binding.time.text = time
    }


}