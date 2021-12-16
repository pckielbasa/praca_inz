package com.example.praca_inz.ui.meals.mealsMenu.snack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment
import com.example.praca_inz.R

class AddSnackMealsFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_add_snack_meals, container, false)

        rootView.findViewById<ImageButton>(R.id.closeSnackWindow).setOnClickListener {
            dismiss()
        }

        return rootView
    }



}