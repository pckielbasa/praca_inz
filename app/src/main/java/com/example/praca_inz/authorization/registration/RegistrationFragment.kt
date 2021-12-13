package com.example.praca_inz.authorization.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.R
import com.example.praca_inz.authorization.login.LoginFragment
import com.example.praca_inz.authorization.login.LoginViewModel
import com.example.praca_inz.databinding.FragmentLoginBinding
import com.example.praca_inz.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {

    private val registrationViewModel: RegistrationViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, RegistrationViewModel.RegistrationViewModelFactory(activity.application))[RegistrationViewModel::class.java]
    }
    private lateinit var binding: FragmentRegistrationBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.registrationViewModel = registrationViewModel

        binding.backButtonRegister.setOnClickListener {

            navToLoginFragment()
            clearStack()
        }

        binding.registerButtonRegister.setOnClickListener {
            registerSuccessful()
            clearStack()
        }

        return binding.root    }

    fun navToLoginFragment(){

        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragmentContainerView, LoginFragment())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }

    fun registerSuccessful(){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragmentContainerView, LoginFragment())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
        Toast.makeText(activity,"Registration successful!",Toast.LENGTH_LONG).show();
    }

    fun clearStack(){
        val fm = requireActivity().supportFragmentManager
        for (i in 0 until fm.backStackEntryCount) {
            fm.popBackStack()
        }
    }
}