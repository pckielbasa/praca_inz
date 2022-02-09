package com.example.praca_inz.ui.reportAllergy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.praca_inz.databinding.FragmentReportAllergyBinding

class ReportAllergyFragment : Fragment() {

    private lateinit var binding:FragmentReportAllergyBinding
    private val reportViewModel: ReportAllergyViewModel by lazy {
        ViewModelProvider(this)[ReportAllergyViewModel::class.java]
    }
    private val args:ReportAllergyFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentReportAllergyBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.reportViewModel = reportViewModel
        val foodId = args.foodId
        val contactId = args.contactId
        binding.textView27.text = foodId
        binding.textView28.text = contactId
        return binding.root
    }



}