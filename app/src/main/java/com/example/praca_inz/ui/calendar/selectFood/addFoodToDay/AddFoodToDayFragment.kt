package com.example.praca_inz.ui.calendar.selectFood.addFoodToDay

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.praca_inz.R
import com.example.praca_inz.data.DayItem
import com.example.praca_inz.data.DaySchedule
import com.example.praca_inz.databinding.AddFoodToDayFragmentBinding
import com.example.praca_inz.network.RestApiService
import com.example.praca_inz.ui.calendar.CalendarViewModel
import com.google.firebase.auth.FirebaseAuth
import java.text.SimpleDateFormat
import java.util.*

class AddFoodToDayFragment : Fragment() {

    private lateinit var binding:AddFoodToDayFragmentBinding
    private val addFoodToDayViewModel: AddFoodToDayViewModel by lazy {
        ViewModelProvider(this)[AddFoodToDayViewModel::class.java]
    }

    private lateinit var tvDataPicker : TextView

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

        tvDataPicker = binding.date

        addFoodToDayViewModel.goToSelectFood.observe(viewLifecycleOwner, { goOpen ->
            if(goOpen){
                backToFood()
                addFoodToDayViewModel.selectFoodFinish()
            }
        })

        addFoodToDayViewModel.goToChangeTime.observe(viewLifecycleOwner,{ change->
            if (change){
                changeTime()
                addFoodToDayViewModel.changeTimeFinish()
            }
        })

        binding.confirmButton.setOnClickListener {

        }

        //Wyswietlanie aktualnej daty
        val date = getCurrentDateTime()
        val dateInString = date.toString("dd/MM/yyyy")
        binding.date.text = dateInString

        //Zmiana Daty
        tvDataPicker = binding.date
        var dateString = getCurrentDateTime().toString("dd/MM/yyyy")
        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            val myMonth = month.plus(1)
            dateString = if (myMonth < 10 && dayOfMonth<10){
                "0$dayOfMonth/0$myMonth/$year"
            }else if (myMonth<10 && dayOfMonth>=10){
                "$dayOfMonth/0$myMonth/$year"
            }else if (myMonth>=10 && dayOfMonth<10){
                "0$dayOfMonth/$myMonth/$year"
            }else{
                "$dayOfMonth/$myMonth/$year"
            }

            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(myCalendar)
            val apiService = RestApiService()
            val username = FirebaseAuth.getInstance().currentUser!!.uid
            val daySchedule = DaySchedule(
                username = username,
                dayDate = dateString
            )
            apiService.addDaySchedule(daySchedule){
            }
            Log.i("test", dateString)
        }
        addFoodToDayViewModel.openNavCalendar.observe(viewLifecycleOwner,  { openData ->
            if (openData) {
                activity?.let { DatePickerDialog(it,
                    datePicker,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show() }
                addFoodToDayViewModel.changeDateFinish()
            }
        })

        binding.confirmButton.setOnClickListener {
            val username:String = FirebaseAuth.getInstance().currentUser!!.uid
            val dayDate:String = binding.date.text.toString()
            val time:String = binding.time.text.toString()
            val itemId:String = addFoodToDayViewModel.selectedProperty.value!!._id
            val itemName:String = addFoodToDayViewModel.selectedProperty.value!!.foodName
            val itemCompo:String = addFoodToDayViewModel.selectedProperty.value!!.composition
            val type:String = addFoodToDayViewModel.selectedProperty.value!!.type
            val apiService = RestApiService()
            val dayItem = DayItem(
                dayDate = dayDate,
                username = username,
                itemId = itemId,
                time = time,
                itemName = itemName,
                itemCompo = itemCompo,
                type = type
            )
            apiService.addItemDay(dayItem){
                if (it != null){
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                    backToFood()
                } else {
                    Toast.makeText(context, "Wrong data", Toast.LENGTH_SHORT).show()
                }
            }
        }

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



    private fun changeTime(){
        val c = Calendar.getInstance()
        val timePicker = TimePickerDialog(requireContext(), TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            val selectedTime = Calendar.getInstance()
            selectedTime.set(Calendar.HOUR_OF_DAY,hourOfDay)
            selectedTime.set(Calendar.MINUTE,minute)
            val changeHour= selectedTime.time.hours
            val changeMinute = selectedTime.time.minutes
            val changeTimer = if (changeHour<10 && changeMinute < 10){
                "0$changeHour : 0$changeMinute"
            }else if (changeHour<10 && changeMinute >= 10){
                "0$changeHour : $changeMinute"
            }else if(changeHour>=10 && changeMinute <10){
                "$changeHour : 0$changeMinute"
            }else{
                "$changeHour : $changeMinute"
            }
            binding.time.text = changeTimer
        },
            c.get(Calendar.HOUR_OF_DAY),
            c.get(Calendar.MINUTE),
            true)
        timePicker.show()

    }

    //Wyswietlanie aktualnej daty
    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }
    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }
    //--------------------------------

    fun updateLabel(myCalendar: Calendar, locale: Locale = Locale.getDefault()) {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
        tvDataPicker.text = sdf.format(myCalendar.time)
    }

}