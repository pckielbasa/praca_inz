package com.example.praca_inz.ui.calendar

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.praca_inz.MainActivity
import com.example.praca_inz.R
import com.example.praca_inz.data.DaySchedule
import com.example.praca_inz.databinding.FragmentCalendarBinding
import com.example.praca_inz.network.RestApiService
import com.example.praca_inz.ui.calendar.CalendarGridAdapter.OnClickListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class CalendarFragment : Fragment(){
    private val calendarViewModel: CalendarViewModel by lazy {
        ViewModelProvider(this)[CalendarViewModel::class.java]
    }
    private lateinit var auth: FirebaseAuth
    private lateinit var tvDataPicker : TextView
    private lateinit var binding: FragmentCalendarBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.calendarViewModel = calendarViewModel
        auth = Firebase.auth

        //Zmiana Daty
        tvDataPicker = binding.dateCalendar
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
            calendarViewModel.setDate(dateString)
            calendarViewModel.getMyDay()
            Log.i("test", dateString)
        }
        calendarViewModel.openNavCalendar.observe(viewLifecycleOwner, Observer { openData ->
            if (openData) {
                activity?.let { DatePickerDialog(it, datePicker, myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show() }

                calendarViewModel.openNavCalendarFinished()
            }
        })

                //Wyswietlanie aktualnej daty
                val date = getCurrentDateTime()
                val dateInString = date.toString("dd/MM/yyyy")
                calendarViewModel.setDate(dateString)
                binding.dateCalendar.text = dateInString

        binding.addFoodDayButton.setOnClickListener {
            val navController = NavHostFragment.findNavController(this)
            navController.navigate(R.id.action_navigation_calendar_to_selectFoodFragment)
        }

        binding.addContactDayButton.setOnClickListener {
                    val navController = NavHostFragment.findNavController(this)
            navController.navigate(R.id.action_navigation_calendar_to_selectContactFragment)
        }



        binding.calendarGrid.adapter = CalendarGridAdapter(OnClickListener {
            calendarViewModel.displayPropertyDetails(it) })

        calendarViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(CalendarFragmentDirections.actionNavigationCalendarToDetailDayFragment(it))
                calendarViewModel.displayPropertyDetailsComplete()
            }
        })
                return binding.root
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