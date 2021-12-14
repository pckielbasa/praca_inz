package com.example.praca_inz.ui.meals

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.databinding.FragmentMealsBinding
import com.example.praca_inz.ui.meals.mealsMenu.ViewPagerMealsAdapter
import com.google.android.material.tabs.TabLayoutMediator


class MealsFragment : Fragment() {

    private val mealsViewModel: MealsViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, MealsViewModel.MealsViewModelFactory(activity.application))[MealsViewModel::class.java]
    }

    private lateinit var binding: FragmentMealsBinding


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMealsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.mealsViewModel = mealsViewModel



        //Menu Meals
        val tabLayout = binding.tabLayoutMeals
        val viewPager2 = binding.viewPagerMeals
        val adapter=ViewPagerMealsAdapter(requireActivity().supportFragmentManager, lifecycle)

        viewPager2.adapter=adapter

        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            when(position){
                0->{
                    tab.text="Meals"
                }
                1->{
                    tab.text="Snacks"
                }
                2->{
                    tab.text="Components"
                }
            }
        }.attach()

        return binding.root
    }



}