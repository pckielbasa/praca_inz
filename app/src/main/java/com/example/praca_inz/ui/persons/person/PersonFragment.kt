package com.example.praca_inz.ui.persons.person

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.praca_inz.R
import com.example.praca_inz.authorization.registration.RegistrationFragment
import com.example.praca_inz.databinding.FragmentPersonBinding
import com.example.praca_inz.ui.persons.addPerson.AddPersonFragment


class PersonFragment : Fragment() {

    private val personViewModel: PersonViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, PersonViewModel.PersonViewModelFactory(activity.application)).get(
            PersonViewModel::class.java)
    }

    private lateinit var binding: FragmentPersonBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.personViewModel = personViewModel

        personViewModel.goAddPerson.observe(viewLifecycleOwner, { goAdd ->
            if(goAdd){

                goToAddPerson()
                personViewModel.goAddPersonFinished()
            }
        })

        return binding.root
    }

    fun goToAddPerson(){

        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragmentContainerViewPerson, AddPersonFragment())
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

}