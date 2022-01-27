package com.example.praca_inz.ui.food.addFood

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.praca_inz.R
import com.example.praca_inz.data.Food
import com.example.praca_inz.databinding.AddFoodFragmentBinding
import com.example.praca_inz.network.FoodApiFilter
import com.example.praca_inz.network.RestApiService
import com.example.praca_inz.ui.food.FoodFragment
import com.example.praca_inz.ui.food.FoodFragmentDirections
import com.example.praca_inz.ui.food.FoodViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.add_food_fragment.*
import android.content.DialogInterface




class AddFoodFragment : DialogFragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: AddFoodFragmentBinding
    private val foodViewModel: FoodViewModel by lazy {
        ViewModelProvider(this)[FoodViewModel::class.java]
    }




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        auth = Firebase.auth
        binding = AddFoodFragmentBinding.inflate(inflater, container, false)
        val mySpinner = binding.spinner
        var typeFood = ""
        val myAdapter = ArrayAdapter(
            requireActivity(),
            android.R.layout.simple_list_item_1, resources.getStringArray(R.array.food_things)
        )
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mySpinner.adapter = myAdapter

        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
                when (i) {
                    0 -> {
                        //                    startActivity(Intent(activity, HomeActivity::class.java))
                        typeFood = myAdapter.getItem(0).toString();
                        Toast.makeText(activity, "Wybrano 1" + typeFood, Toast.LENGTH_SHORT).show()
                    }
                    1 -> {
                        //                    startActivity(Intent(activity, HomeActivity::class.java))
                        typeFood = myAdapter.getItem(1).toString();
                        Toast.makeText(activity, "Wybrano 1" + typeFood, Toast.LENGTH_SHORT).show()
                    }
                    2 -> {
                        typeFood = myAdapter.getItem(2).toString();
                        Toast.makeText(activity, "Wybrano 2" + typeFood, Toast.LENGTH_SHORT).show()
                    }

                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }


        binding.addFoodBtn.setOnClickListener {
            when{
                TextUtils.isEmpty(etFoodName.text.toString().trim { it <=' ' })->{
                    Toast.makeText(
                        this.context,
                        "Pleas enter name.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(etFoodComposition.text.toString().trim { it <=' ' })->{
                    Toast.makeText(
                        this.context,
                        "Pleas enter composition.",
                        Toast.LENGTH_SHORT
                    ).show()
                }else ->{

                    val foodName:String=etFoodName.text.toString().trim { it<=' ' }
                    val foodComposition:String=etFoodComposition.text.toString().trim { it<=' ' }
                    val type:String=typeFood
                    val foodFavourite:Boolean = binding.addFoodFavouriteBtn.isChecked
                    val apiService = RestApiService()
                    val food = Food(
                        username = FirebaseAuth.getInstance().currentUser!!.uid,
                        foodName = foodName,
                        composition = foodComposition,
                        type = type,
                        favourite = foodFavourite
                    )
                    apiService.addFood(food){
                        if (it?.favourite!=false) {


                        } else {

                        }

                    }
                }

            }

            dismiss()

        }

        binding.closeAddFoodWindow.setOnClickListener{
            dismiss()
        }
        return binding.root

    }


}
