package com.example.praca_inz.ui.food.add

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.example.praca_inz.R
import com.example.praca_inz.data.Food
import com.example.praca_inz.databinding.FragmentAddFoodBinding
import com.example.praca_inz.network.RestApiService
import com.example.praca_inz.ui.food.FoodViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_add_food.*

class AddFoodFragment : Fragment() {

    private lateinit var auth:FirebaseAuth
    private lateinit var binding: FragmentAddFoodBinding
    private val addFoodViewModel: AddFoodViewModel by lazy {
        ViewModelProvider(this)[AddFoodViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddFoodBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.addFoodViewModel = addFoodViewModel

        addFoodViewModel.goToFood.observe(viewLifecycleOwner, { goOpen ->
            if(goOpen){
                backToFood()
                addFoodViewModel.foodFinish()
            }
        })

        val mySpinner = binding.spinner
        var typeFood = ""
        val myAdapter = ArrayAdapter(
            requireActivity(),
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.food_things)
        )
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mySpinner.adapter = myAdapter

        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                adapterView: AdapterView<*>,
                view: View,
                i: Int,
                l: Long
            ){
                when(i){
                    0->{
                        typeFood = myAdapter.getItem(0).toString()
                    }
                    1->{
                        typeFood = myAdapter.getItem(1).toString()
                    }
                    2->{
                        typeFood = myAdapter.getItem(2).toString()
                    }
                }
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {
            }
        }

        binding.addFoodBtn.setOnClickListener {
            when{
                TextUtils.isEmpty(etFoodName.text.toString().trim{it <= ' '}) -> {
                    Toast.makeText(
                        this.context,
                        "Pleas enter food name.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(etFoodComposition.text.toString().trim{it <= ' '}) -> {
                    Toast.makeText(
                        this.context,
                        "Pleas enter food  composition.",
                        Toast.LENGTH_SHORT
                    ).show()
                }else ->{
                    val foodName:String = etFoodName.text.toString().trim { it<=' '}
                    val foodComposition:String = etFoodComposition.text.toString().trim { it<=' '}
                    val type =  typeFood
                    val foodFavourite:Boolean = binding.checkBox.isChecked
                    val apiService = RestApiService()
                    val food = Food(
                        username = FirebaseAuth.getInstance().currentUser!!.uid,
                        foodName = foodName,
                        composition = foodComposition,
                        type = type,
                        favourite = foodFavourite,
                        allergy = false
                    )
                    apiService.addFood(food){
                        if(it==null){
                            Toast.makeText(
                                this.context,
                                "Food already exist.",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else{
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

        return binding.root
    }

    private fun backToFood(){
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_addFoodFragment_to_navigation_food)
    }

}