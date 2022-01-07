package com.example.praca_inz.ui.food.addFood

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.praca_inz.R
import com.example.praca_inz.databinding.AddFoodFragmentBinding
import com.example.praca_inz.databinding.FragmentAddContactBinding

class AddFoodFragment : DialogFragment() {


    private lateinit var binding: AddFoodFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = AddFoodFragmentBinding.inflate(inflater, container, false)
        val mySpinner = binding.spinner
        var typeContact = ""
        val myAdapter = ArrayAdapter(
            requireActivity(),
            android.R.layout.simple_list_item_1, resources.getStringArray(R.array.food_things)
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



        binding.closeAddFoodWindow.setOnClickListener{
            dismiss()
        }

        return binding.root
    }

}