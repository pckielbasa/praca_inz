package com.example.praca_inz.ui.contact.addContact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.R
import android.widget.*
import com.example.praca_inz.databinding.FragmentAddContactBinding
import com.example.praca_inz.databinding.FragmentContactBinding


class AddContactFragment : DialogFragment() {

    private lateinit var binding: FragmentAddContactBinding

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

        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
                when (i) {
                    0 -> {
                        //                    startActivity(Intent(activity, HomeActivity::class.java))
                        typeContact = myAdapter.getItem(0).toString();
                        Toast.makeText(activity, "Wybrano 1" + typeContact, Toast.LENGTH_SHORT).show()
                    }
                    1 -> {
            //                    startActivity(Intent(activity, HomeActivity::class.java))
                        typeContact = myAdapter.getItem(1).toString();
                        Toast.makeText(activity, "Wybrano 1" + typeContact, Toast.LENGTH_SHORT).show()
                    }
                    2 -> {
                        typeContact = myAdapter.getItem(2).toString();
                        Toast.makeText(activity, "Wybrano 2" + typeContact, Toast.LENGTH_SHORT).show()
                    }

                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }



        binding.closeAddContactWindow.setOnClickListener{
            dismiss()
        }

        return binding.root
    }


}