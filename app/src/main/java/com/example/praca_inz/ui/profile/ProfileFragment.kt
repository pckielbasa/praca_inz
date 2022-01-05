package com.example.praca_inz.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.databinding.FragmentProfileBinding
import com.example.praca_inz.ui.persons.PersonActivity


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
       // navToMainActivity()
        return binding.root
    }


    fun navToMainActivity(){

        val intent = Intent(context, PersonActivity::class.java)
        activity?.finish()
        startActivity(intent)
    }
}