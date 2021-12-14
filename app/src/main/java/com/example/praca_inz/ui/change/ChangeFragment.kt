package com.example.praca_inz.ui.change

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.MainActivity
import com.example.praca_inz.R
import com.example.praca_inz.authorization.AuthorizationActivity
import com.example.praca_inz.databinding.FragmentCalendarBinding
import com.example.praca_inz.databinding.FragmentChangeBinding
import com.example.praca_inz.ui.calendar.CalendarViewModel
import com.example.praca_inz.ui.persons.PersonActivity


class ChangeFragment : Fragment() {

    private lateinit var binding: FragmentChangeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChangeBinding.inflate(inflater, container, false)
        navToMainActivity()
        return binding.root
    }


    fun navToMainActivity(){

        val intent = Intent(context, PersonActivity::class.java)
        activity?.finish()
        startActivity(intent)
    }
}