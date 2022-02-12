package com.example.praca_inz.ui.calendar.selectContact.addContactToDay

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.praca_inz.R
import com.example.praca_inz.databinding.AddContactToDayFragmentBinding
import java.util.*

class AddContactToDayFragment : Fragment() {


    private lateinit var binding: AddContactToDayFragmentBinding
    private val addContactToDayViewModel: AddContactToDayViewModel by lazy {
        ViewModelProvider(this)[AddContactToDayViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(activity).application
        binding = AddContactToDayFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val myContactProperty = AddContactToDayFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = AddContactToDarViewModelFactory(myContactProperty, application)
        binding.addContactToDayViewModel = ViewModelProvider(
            this, viewModelFactory)[AddContactToDayViewModel::class.java]

        setLocalTime()

        addContactToDayViewModel.goToSelectContact.observe(viewLifecycleOwner, { goOpen ->
            if(goOpen){
                backToContact()
                addContactToDayViewModel.selectContactFinish()
            }
        })

        return binding.root
    }
    private fun backToContact(){
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_addContactToDayFragment_to_navigation_calendar )
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