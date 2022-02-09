package com.example.praca_inz.ui.allergies.addAllergies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import com.example.praca_inz.R
import com.example.praca_inz.databinding.FragmentAddAllergiesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class AddAllergiesFragment : DialogFragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentAddAllergiesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = Firebase.auth
        binding = FragmentAddAllergiesBinding.inflate(inflater, container, false)
        val mySpinner = binding.spinner
        var typeAllergies = ""
        val myAdapter = ArrayAdapter(
            requireActivity(),
            android.R.layout.simple_list_item_1, resources.getStringArray(R.array.type_allergies)
        )
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mySpinner.adapter = myAdapter

        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
                when (i) {
                    0 -> {
                        typeAllergies = myAdapter.getItem(0).toString();
                    }
                    1 -> {
                        typeAllergies = myAdapter.getItem(1).toString();
                    }
                    2 -> {
                        typeAllergies = myAdapter.getItem(2).toString();
                    }

                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
        return binding.root
    }


}