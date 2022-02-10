package com.example.praca_inz.ui.calendar.datepicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.praca_inz.databinding.DatepickerFragmentBinding
import java.util.*

class DatepickerFragment : Fragment() {
    private lateinit var binding: DatepickerFragmentBinding
    private lateinit var viewModel: DatepickerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DatepickerFragmentBinding.inflate(inflater, container, false)
        val datePicker = DatePicker(context)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        datePicker.layoutParams = layoutParams
        val linearLayout =binding.linearLayout
        linearLayout?.addView(datePicker)

        val today = Calendar.getInstance()
        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)){ view, year, month, day ->
            val month = month + 1
            val msg = "You Selected: $day/$month/$year"
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

        }

        return binding.root
    }



}