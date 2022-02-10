package com.example.praca_inz.ui.reportAllergy

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.praca_inz.R
import com.example.praca_inz.data.AllergiesReport
import com.example.praca_inz.databinding.FragmentReportAllergyBinding
import com.example.praca_inz.network.RestApiService
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_report_allergy.*

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
        val type = args.type
        val allergenName = args.allergenName

        binding.addAllergyReportButton.setOnClickListener {
            when{
                TextUtils.isEmpty(etAllergyName.text.toString().trim{it <= ' '}) -> {
                    Toast.makeText(
                        this.context,
                        "Pleas enter allergy name.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(etAfterTime.text.toString().trim{it <= ' '}) -> {
                    Toast.makeText(
                        this.context,
                        "Pleas enter after time.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(etSymptoms.text.toString().trim{it <= ' '}) -> {
                    Toast.makeText(
                        this.context,
                        "Pleas enter symptoms.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(etAllergyName.text.toString().trim{it <= ' '}) -> {
                    Toast.makeText(
                        this.context,
                        "Pleas enter how can help",
                        Toast.LENGTH_SHORT
                    ).show()
                }else->{
                val allergiesName:String = etAllergyName.text.toString().trim { it<=' '}
                val afterTime:String = etAfterTime.text.toString().trim{it<=' '}
                val symptoms:String = etSymptoms.text.toString().trim { it<=' '}
                val help:String = etHelp.text.toString().trim { it<=' '}
                val apiService = RestApiService()
                    if (foodId == "null"){
                        val allergiesReport = AllergiesReport(
                            username = FirebaseAuth.getInstance().currentUser!!.uid,
                            allergenId = contactId,
                            type = type,
                            allergenName = allergenName,
                            allergiesName = allergiesName,
                            afterTime = afterTime,
                            symptoms = symptoms,
                            help = help
                        )
                        apiService.addAllergy(allergiesReport){
                            if(it==null){
                                Toast.makeText(
                                    this.context,
                                    "Report for this position already exist.",
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
                    }else{
                        val allergiesReport = AllergiesReport(
                            username = FirebaseAuth.getInstance().currentUser!!.uid,
                            allergenId = foodId,
                            type = type,
                            allergenName = allergenName,
                            allergiesName = allergiesName,
                            afterTime = afterTime,
                            symptoms = symptoms,
                            help = help
                        )
                        apiService.addAllergy(allergiesReport){
                            if(it==null){
                                Toast.makeText(
                                    this.context,
                                    "Report for this position already exist.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }else{
                                Toast.makeText(
                                    this.context,
                                    "Successful addition.",
                                    Toast.LENGTH_SHORT
                                ).show()


                                backToFood()
                            }
                        }
                    }
                }
            }
        }
        return binding.root
    }
    private fun backToFood(){
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_reportAllergyFragment_to_navigation_food)
    }

    private fun backToContact(){
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_reportAllergyFragment_to_navigation_contact)
    }
}