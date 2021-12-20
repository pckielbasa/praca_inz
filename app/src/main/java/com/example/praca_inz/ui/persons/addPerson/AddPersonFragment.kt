package com.example.praca_inz.ui.persons.addPerson

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.R
import com.example.praca_inz.authorization.login.LoginFragment
import com.example.praca_inz.authorization.login.LoginViewModel
import com.example.praca_inz.databinding.FragmentAddPersonBinding
import com.example.praca_inz.databinding.FragmentCalendarBinding
import com.example.praca_inz.databinding.FragmentLoginBinding
import com.example.praca_inz.ui.persons.person.PersonFragment
import java.text.SimpleDateFormat
import java.util.*






class AddPersonFragment : Fragment() {

    private lateinit var binding: FragmentAddPersonBinding
    private lateinit var tvDataPicker : TextView
    private lateinit var setListener: DatePickerDialog.OnDateSetListener

    private val addPersonViewModel: AddPersonViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, AddPersonViewModel.AddPersonViewModelFactory(activity.application)).get(
            AddPersonViewModel::class.java)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddPersonBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.addPersonViewModel = addPersonViewModel

        binding.addPersonButton.setOnClickListener {
            addPersonSuccessful()
            clearStack()
        }

        addPersonViewModel.goBackToPerson.observe(viewLifecycleOwner, { goAdd ->
            if(goAdd){
                backToPerson()
                addPersonViewModel.goBackToPersonFinished()
                clearStack()
            }
        })

        tvDataPicker = binding.tvDateOfBirth
        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(myCalendar)
        }

        addPersonViewModel.openNavCalendar.observe(viewLifecycleOwner, { openData2 ->
            if (openData2) {
                activity?.let { DatePickerDialog(it, datePicker, myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show() }
                addPersonViewModel.openNavCalendarFinished()


            }
        })

        return binding.root
    }

    fun addPersonSuccessful(){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragmentContainerViewPerson, PersonFragment())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }

    fun backToPerson(){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragmentContainerViewPerson, PersonFragment())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }
    fun clearStack(){
        val fm = requireActivity().supportFragmentManager
        for (i in 0 until fm.backStackEntryCount) {
            fm.popBackStack()
        }
    }

    fun updateLabel(myCalendar: Calendar, locale: Locale = Locale.getDefault()) {
        val myFormat = "dd-MM-yyy"
        val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
        tvDataPicker.setText(sdf.format(myCalendar.time))
    }
}