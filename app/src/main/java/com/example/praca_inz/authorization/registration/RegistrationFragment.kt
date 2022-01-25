package com.example.praca_inz.authorization.registration


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.praca_inz.authorization.AuthorizationActivity
import com.example.praca_inz.data.User
import com.example.praca_inz.databinding.FragmentRegistrationBinding
import com.example.praca_inz.network.JsonPlaceholderApi
import com.example.praca_inz.network.RestApiService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.android.synthetic.main.fragment_registration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegistrationFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var registrationViewModel: RegistrationViewModel
    private lateinit var binding: FragmentRegistrationBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        auth = Firebase.auth
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

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
                val surname:String=etSurname.text.toString().trim { it<=' ' }
                val email:String=etEmail.text.toString().trim { it<=' ' }
                val password:String=etPassword.text.toString().trim { it<=' ' }
                val phoneNumber:String=etPhoneNumber.text.toString().trim { it<=' ' }

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val firebaseUser: FirebaseUser = task.result!!.user!!
                            val firebaseUID = firebaseUser.uid
                            Toast.makeText(
                                this.context,
                                "Register successfully !!",
                                Toast.LENGTH_SHORT
                            ).show()

                            val apiService = RestApiService()
                            val user = User(  username = firebaseUID,
                                email = email,
                                name = name,
                                surname = surname,
                                phoneNumber = phoneNumber )

                            apiService.addUser(user) {
                                if (it?.username != null) {

                                } else {
                                    Toast.makeText(
                                        this.context,
                                        "",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }

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