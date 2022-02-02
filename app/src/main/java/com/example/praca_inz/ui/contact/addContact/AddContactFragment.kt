package com.example.praca_inz.ui.contact.addContact

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.R
import android.widget.*
import com.example.praca_inz.data.Contact
import com.example.praca_inz.databinding.FragmentAddContactBinding
import com.example.praca_inz.databinding.FragmentContactBinding
import com.example.praca_inz.network.RestApiService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.add_food_fragment.*
import kotlinx.android.synthetic.main.fragment_add_contact.*


class AddContactFragment : DialogFragment() {

    private lateinit var binding: FragmentAddContactBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentAddContactBinding.inflate(inflater, container, false)
        val mySpinner = binding.spinner
        var typeContact = ""
        val myAdapter = ArrayAdapter(
            requireActivity(),
            android.R.layout.simple_list_item_1, resources.getStringArray(R.array.contact_things)
        )
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mySpinner.adapter = myAdapter
        auth = Firebase.auth
        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
                when (i) {
                    0 -> {
                        typeContact = myAdapter.getItem(0).toString();
                    }
                    1 -> {
                        typeContact = myAdapter.getItem(1).toString();
                    }
                    2 -> {
                        typeContact = myAdapter.getItem(2).toString();
                    }

                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }


        binding.addContactBtn.setOnClickListener {
            when{
                TextUtils.isEmpty(etContactName.text.toString().trim { it <=' ' })->{
                    Toast.makeText(
                        this.context,
                        "Pleas enter name.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(etContactComposition.text.toString().trim { it <=' ' })->{
                    Toast.makeText(
                        this.context,
                        "Pleas enter composition.",
                        Toast.LENGTH_SHORT
                    ).show()
                }else -> {
                    val contactName:String = etContactName.text.toString().trim{it<=' '}
                    val contactComposition:String = etContactComposition.text.toString().trim{it<=' '}
                    val type:String = typeContact
                    val contactFavourite:Boolean = binding.addContactFavouriteBtn.isChecked
                    val apiService = RestApiService()
                    val contact = Contact(
                        username =  FirebaseAuth.getInstance().currentUser!!.uid,
                        contactName = contactName,
                        composition = contactComposition,
                        type = type,
                        favourite = contactFavourite,
                        allergy = false
                    )
                apiService.addContact(contact){
                    if (it==null){
                        Toast.makeText(
                            this.context,
                            "Contact already exist",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            }
            }
            this.dismiss()

        }

        binding.closeAddContactWindow.setOnClickListener{
            this.dismiss()
        }

        return binding.root
    }


}