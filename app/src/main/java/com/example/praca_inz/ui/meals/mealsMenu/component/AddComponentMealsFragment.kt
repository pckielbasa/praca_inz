package com.example.praca_inz.ui.meals.mealsMenu.component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment
import com.example.praca_inz.R

class AddComponentMealsFragment: DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_add_component_meals, container, false)

        rootView.findViewById<ImageButton>(R.id.closeComponentWindow).setOnClickListener {
            dismiss()
        }

        return rootView
    }



}