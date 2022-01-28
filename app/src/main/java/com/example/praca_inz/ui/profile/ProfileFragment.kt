package com.example.praca_inz.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.authorization.AuthorizationActivity
import com.example.praca_inz.databinding.FragmentProfileBinding
import com.example.praca_inz.network.username
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class ProfileFragment : Fragment() {

    private val profileViewModel: ProfileViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, ProfileViewModel.ProfileViewModelFactory(activity.application)).get(
            ProfileViewModel::class.java)
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



    fun logoutFromApp(){
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(context, AuthorizationActivity::class.java)
        activity?.finish()
        startActivity(intent)
    }
}