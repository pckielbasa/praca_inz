package com.example.praca_inz.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.authorization.AuthorizationActivity
import com.example.praca_inz.databinding.FragmentProfileBinding
import com.example.praca_inz.ui.food.FoodViewModel
import com.google.firebase.auth.FirebaseAuth


class ProfileFragment : Fragment() {

    private val profileViewModel: ProfileViewModel by lazy {
        ViewModelProvider(this)[ProfileViewModel::class.java]
    }

    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.profileViewModel = profileViewModel

        profileViewModel.goLogout.observe(viewLifecycleOwner, { goOut ->
            if(goOut){
                logoutFromApp()
                profileViewModel.goLogoutFinished()
            }
        })


        return binding.root
    }


    private fun logoutFromApp(){
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(context, AuthorizationActivity::class.java)
        activity?.finish()
        startActivity(intent)
    }
}