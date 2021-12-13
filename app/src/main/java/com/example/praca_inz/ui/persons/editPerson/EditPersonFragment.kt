package com.example.praca_inz.ui.persons.editPerson

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.praca_inz.R
import com.example.praca_inz.authorization.login.LoginFragment
import com.example.praca_inz.databinding.FragmentEditPersonBinding
import com.example.praca_inz.databinding.FragmentRegistrationBinding
import com.example.praca_inz.ui.persons.person.PersonFragment


class EditPersonFragment : Fragment() {

    private lateinit var binding: FragmentEditPersonBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentEditPersonBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        binding.buttonSaveEdits.setOnClickListener {

            saveEditsFunction()
            clearStack()

        }

        return binding.root
    }

    fun saveEditsFunction(){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragmentContainerViewPerson, PersonFragment())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
        Toast.makeText(activity,"Changes saved!", Toast.LENGTH_LONG).show();

    }

    fun clearStack(){
        val fm = requireActivity().supportFragmentManager
        for (i in 0 until fm.backStackEntryCount) {
            fm.popBackStack()
        }
    }

}