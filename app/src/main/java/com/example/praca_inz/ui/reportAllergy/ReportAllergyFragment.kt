package com.example.praca_inz.ui.reportAllergy

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.R

class ReportAllergyFragment : Fragment() {

    companion object {
        fun newInstance() = ReportAllergyFragment()
    }

    private lateinit var viewModel: ReportAllergyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_report_allergy, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ReportAllergyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}