package com.example.praca_inz.ui.persons.person

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.praca_inz.MainActivity
import com.example.praca_inz.R
import com.example.praca_inz.authorization.registration.RegistrationFragment
import com.example.praca_inz.databinding.FragmentPersonBinding
import com.example.praca_inz.databinding.PersonRowBinding
import com.example.praca_inz.ui.persons.PersonActivity
import com.example.praca_inz.ui.persons.addPerson.AddPersonFragment
import com.example.praca_inz.ui.persons.editPerson.EditPersonFragment
import com.google.android.material.bottomsheet.BottomSheetDialog


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

        personViewModel.goEditPerson.observe(viewLifecycleOwner, { goEdit ->
            if(goEdit){
                goEditPerson()
                personViewModel.goEditPersonFinished()
            }
        })



        return binding.root
    }

    fun goToAddPerson(){

//        val transaction = activity?.supportFragmentManager?.beginTransaction()
//        transaction?.replace(R.id.fragmentContainerViewPerson, AddPersonFragment())
//        transaction?.addToBackStack(null)
//        transaction?.commit()

//        //Test Czy działa edit fragment
//        val transaction = activity?.supportFragmentManager?.beginTransaction()
//        transaction?.replace(R.id.fragmentContainerViewPerson, EditPersonFragment())
//        transaction?.addToBackStack(null)
//        transaction?.commit()

        //TYLKO DLA TESTOW
        val intent = Intent(context, MainActivity::class.java)
        activity?.finish()
        startActivity(intent)
        //------------------------
    }

    fun goEditPerson(){
        val dialog = BottomSheetDialog(this.requireContext())
        val view=layoutInflater.inflate(R.layout.fragment_edit_person,null)
        dialog.setContentView(view)
        dialog.show()
    }

}