package com.example.praca_inz.authorization.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.praca_inz.MainActivity
import com.example.praca_inz.R
import com.example.praca_inz.authorization.registration.RegistrationFragment
import com.example.praca_inz.databinding.FragmentLoginBinding
import com.example.praca_inz.ui.persons.PersonActivity
import com.google.android.material.bottomsheet.BottomSheetDialog


class LoginFragment : Fragment() {


    private val loginViewModel: LoginViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, LoginViewModel.LoginViewModelFactory(activity.application))[LoginViewModel::class.java]
    }

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.loginViewModel = loginViewModel


        binding.loginButtonLogin.setOnClickListener {
            loginSuccessful()
        }

//        loginViewModel.eventGoSignup.observe(viewLifecycleOwner, { goSignup ->
//            if(goSignup){
//                navToRegistrationFragment()
//                loginViewModel.eventGoRegistrationFinished()
//            }
//        })



        return binding.root
    }

//    fun navToRegistrationFragment(){
//
//        val transaction = activity?.supportFragmentManager?.beginTransaction()
//        transaction?.replace(R.id.fragmentContainerView, RegistrationFragment())
//        transaction?.addToBackStack(null)
//        transaction?.commit()
//    }

//    fun checkLogin():Boolean{
//        binding.usernameLogin.text.isNotEmpty().apply {
//            return true
//        }
//    }


    fun loginSuccessful(){
            val intent = Intent(context, PersonActivity::class.java)
            activity?.finish()
            startActivity(intent)

    }



}