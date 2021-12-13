package com.example.praca_inz.ui.calendar

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.databinding.FragmentCalendarBinding
import androidx.lifecycle.Observer
import com.example.praca_inz.authorization.AuthorizationActivity
import java.text.SimpleDateFormat
import java.util.*

class CalendarFragment : Fragment(){
    private val calendarViewModel: CalendarViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, CalendarViewModel.CalendarViewModelFactory(activity.application))[CalendarViewModel::class.java]
    }

    private lateinit var binding: FragmentCalendarBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.calendarViewModel = calendarViewModel



        calendarViewModel.openNavCalendar.observe(viewLifecycleOwner, Observer { openData ->
            if (openData) {
                navToMainActivity()
                calendarViewModel.openNavCalendarFinished()
            }
        })
        //Wyswietlanie aktualnej daty
        val date = getCurrentDateTime()
        val dateInString = date.toString("dd/MM/yyyy")
        binding.dateCalendar.text = dateInString

        calendarViewModel.openNavCalendar.observe(viewLifecycleOwner, Observer { openCalendar ->
            if(openCalendar){
                calendarViewModel.openNavCalendarFinished()
            }
        })
        //--------------------------------

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


    fun navToMainActivity(){
        val intent = Intent(context, AuthorizationActivity::class.java)
        activity?.finish()
        startActivity(intent)
    }


}