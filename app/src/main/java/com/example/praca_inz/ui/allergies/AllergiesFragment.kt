package com.example.praca_inz.ui.allergies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.authorization.login.LoginViewModel
import com.example.praca_inz.databinding.FragmentAllergiesBinding



class AllergiesFragment : Fragment() {

    private val allergiesViewModel: AllergiesViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, AllergiesViewModel.AllergiesViewModelFactory(activity.application))[AllergiesViewModel::class.java]
    }

    private lateinit var binding: FragmentAllergiesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllergiesBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this



//        binding.allergiesViewModel = allergiesViewModel
        return binding.root
    }


}