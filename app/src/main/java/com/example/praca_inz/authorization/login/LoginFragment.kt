package com.example.praca_inz.authorization.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import at.favre.lib.crypto.bcrypt.BCrypt
import com.example.praca_inz.MainActivity
import com.example.praca_inz.data.DaySchedule
import com.example.praca_inz.databinding.FragmentLoginBinding
import com.example.praca_inz.network.RestApiService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_registration.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*


class LoginFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private val loginViewModel: LoginViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, LoginViewModel.LoginViewModelFactory(activity.application))[LoginViewModel::class.java]
    }

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        auth = Firebase.auth
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.loginViewModel = loginViewModel


        binding.loginButtonLogin.setOnClickListener {
            when {
                TextUtils.isEmpty(emailLogin.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this.context,
                        "Pleas enter email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(passwordLogin.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this.context,
                        "Pleas enter password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }else->{
                val email: String = emailLogin.text.toString().trim { it <= ' ' }
                val password: String = passwordLogin.text.toString().trim { it <= ' ' }


                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                this.context,
                                "Login successful.",
                                Toast.LENGTH_SHORT
                            ).show()
                            val apiService = RestApiService()
                            val username = FirebaseAuth.getInstance().currentUser!!.uid
                            val date = getCurrentDateTime()
                            val dateInString = date.toString("dd/MM/yyyy")
                            val intent = Intent(context, MainActivity::class.java)
                            val daySchedule = DaySchedule(
                                username = username,
                                dayDate = dateInString
                            )
                            apiService.addDaySchedule(daySchedule){
                            }
                            startActivity(intent)
                            activity?.finish()
                        } else {
                            Toast.makeText(
                                this.context,
                                task.exception!!.message.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }}
        }
        return binding.root
    }

    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }
    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }




}