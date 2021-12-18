package com.example.praca_inz.ui.meals.mealsMenu.meal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.MyAdapter
import com.example.praca_inz.TestClass
import com.example.praca_inz.databinding.FragmentMealMealsBinding



class MealMealsFragment : Fragment() {

    private val mealMealsViewModel: MealMealsViewModel by lazy {
        ViewModelProvider(this) [MealMealsViewModel::class.java]
    }
    private lateinit var binding: FragmentMealMealsBinding

    private lateinit var newRecyclerView : RecyclerView
    private lateinit var newArrayList: ArrayList<TestClass>
    lateinit var mealsName : Array<String>
    lateinit var componentName:Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentMealMealsBinding.inflate(inflater, container, false)
      binding.lifecycleOwner = this
      binding.mealMealsViewModel =mealMealsViewModel


        //recycle view
//        mealsName = arrayOf(
//            "Makaron",
//            "Pizza",
//            "zapiekanka",
//            "1Makaron",
//            "1Pizza",
//            "1zapiekanka",
//            "2Makaron",
//            "2Pizza",
//            "2zapiekanka",
//            "3Makaron",
//            "3Pizza",
//            "3zapiekanka"
//        )
//
//        componentName= arrayOf(
//            "makaron, sos, pomidory, szpinak,makaron, sos, pomidory, szpinak,makaron, sos, pomidory, szpinak,makaron, sos, pomidory, szpinak,makaron, sos, pomidory, szpinak,makaron, sos, pomidory, szpinak",
//            "ciasto, szynka",
//            "pieczarki",
//            "makaron, sos, pomidory, szpinak",
//            "ciasto, szynka",
//            "pieczarki",
//            "makaron, sos, pomidory, szpinak",
//            "ciasto, szynka",
//            "pieczarki",
//            "makaron, sos, pomidory, szpinak",
//            "ciasto, szynka",
//            "pieczarki"
//        )
//
//        newRecyclerView =  binding.mealMealsRecycleView
//        newRecyclerView.layoutManager = LinearLayoutManager(activity)
//        newRecyclerView.setHasFixedSize(true)
//
//        newArrayList = arrayListOf()
//        getUserdata()

      return binding.root
    }


    fun getUserdata(){
        for(i in mealsName.indices)
        {
            val testClass = TestClass(mealsName[i],componentName[i])
            newArrayList.add(testClass)
        }
        newRecyclerView.adapter = MyAdapter(newArrayList)
    }
}