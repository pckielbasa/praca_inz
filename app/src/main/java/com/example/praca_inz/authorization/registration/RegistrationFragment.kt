package com.example.praca_inz.authorization.registration


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import at.favre.lib.crypto.bcrypt.BCrypt
import com.example.praca_inz.authorization.AuthorizationActivity
import com.example.praca_inz.databinding.FragmentRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private val registrationViewModel: RegistrationViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, RegistrationViewModel.RegistrationViewModelFactory(activity.application))[RegistrationViewModel::class.java]
    }
    private lateinit var binding: FragmentRegistrationBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        auth = Firebase.auth
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.registrationViewModel = registrationViewModel

        //Firebase registration
        binding.registerButton.setOnClickListener {
            when{
                TextUtils.isEmpty(etName.text.toString().trim { it <=' ' })->{
                    Toast.makeText(
                        this.context,
                        "Pleas enter name.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(etSurname.text.toString().trim { it <=' ' })->{
                    Toast.makeText(
                        this.context,
                        "Pleas enter surname.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(etEmail.text.toString().trim { it <=' ' })->{
                    Toast.makeText(
                        this.context,
                        "Pleas enter email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(etPassword.text.toString().trim { it <=' ' })->{
                    Toast.makeText(
                        this.context,
                        "Pleas enter password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(etPhoneNumber.text.toString().trim { it <=' ' })->{
                    Toast.makeText(
                        this.context,
                        "Pleas enter phone number.",
                        Toast.LENGTH_SHORT
                    ).show()
                }else ->
            {
                val name:String=etName.text.toString().trim { it<=' ' }
                val surname:String=etPassword.text.toString().trim { it<=' ' }
                val email:String=etEmail.text.toString().trim { it<=' ' }
                val password:String=etPassword.text.toString().trim { it<=' ' }
                val phoneNumber:String=etPhoneNumber.text.toString().trim { it<=' ' }


                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val firebaseUser: FirebaseUser = task.result!!.user!!
                            Toast.makeText(
                                this.context,
                                "Register successfully !!",
                                Toast.LENGTH_SHORT
                            ).show()

                            val intent = Intent(this.context, AuthorizationActivity::class.java)
                            intent.flags =
                                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
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

            }

            }
        }



        return binding.root    }




}