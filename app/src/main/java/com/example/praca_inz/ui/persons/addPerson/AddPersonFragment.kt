package com.example.praca_inz.ui.persons.addPerson

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.R
import com.example.praca_inz.authorization.login.LoginFragment
import com.example.praca_inz.authorization.login.LoginViewModel
import com.example.praca_inz.databinding.FragmentAddPersonBinding
import com.example.praca_inz.databinding.FragmentLoginBinding
import com.example.praca_inz.ui.persons.person.PersonFragment


class AddPersonFragment : Fragment() {

    private val addPersonViewModel: AddPersonViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, AddPersonViewModel.AddPersonViewModelFactory(activity.application)).get(
            AddPersonViewModel::class.java)
    }

    private lateinit var binding: FragmentAddPersonBinding

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

}