package com.example.praca_inz.ui.contact.add

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.praca_inz.R
import com.example.praca_inz.data.Contact
import com.example.praca_inz.databinding.FragmentAddContactBinding
import com.example.praca_inz.network.RestApiService
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_add_contact.*

class AddContactFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentAddContactBinding
    private val addContactViewModel: AddContactViewModel by lazy {
        ViewModelProvider(this)[AddContactViewModel::class.java]
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddContactBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.addContactViewModel = addContactViewModel

        addContactViewModel.goToContact.observe(viewLifecycleOwner, { goOpen ->
            if(goOpen){
                backToContact()
                addContactViewModel.contactFinish()
            }
        })

        val mySpinner = binding.spinner
        var typeContact = ""
        val myAdapter = ArrayAdapter(
            requireActivity(),
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.contact_things)
        )
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mySpinner.adapter = myAdapter

        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                adapterView: AdapterView<*>,
                view: View,
                i: Int,
                l: Long
            ){
                when(i){
                    0->{
                        typeContact = myAdapter.getItem(0).toString()
                    }
                    1->{
                        typeContact = myAdapter.getItem(1).toString()
                    }
                    2->{
                        typeContact = myAdapter.getItem(2).toString()
                    }
                }
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {
            }
        }
        binding.addContactBtn.setOnClickListener {
            when{
                TextUtils.isEmpty(etContactName.text.toString().trim{it <= ' '}) -> {
                    Toast.makeText(
                        this.context,
                        "Pleas enter contact name.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(etContactPossibleAllergen.text.toString().trim{it <= ' '}) -> {
                    Toast.makeText(
                        this.context,
                        "Pleas enter possible allergen.",
                        Toast.LENGTH_SHORT
                    ).show()
                }else->{
                val contactName:String = etContactName.text.toString().trim { it<=' '}
                val possibleAllergen:String = etContactPossibleAllergen.text.toString().trim { it<=' '}
                val type =  typeContact
                val contactFavourite:Boolean = binding.checkBox.isChecked
                val apiService = RestApiService()
                val contact = Contact(
                    username =  FirebaseAuth.getInstance().currentUser!!.uid,
                    contactName = contactName,
                    composition = possibleAllergen,
                    type = type,
                    favourite = contactFavourite
                )
                apiService.addContact(contact){
                    if (it == null){
                        Toast.makeText(
                            this.context,
                            "Contact already exist.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }else{
                        Toast.makeText(
                            this.context,
                            "Successful addition.",
                            Toast.LENGTH_SHORT
                        ).show()
                        backToContact()
                    }
                }
                 }
            }
        }

       return binding.root
    }

    private fun backToContact(){
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_addContactFragment_to_navigation_contact )
    }

}