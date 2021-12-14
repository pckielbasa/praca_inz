package com.example.praca_inz.ui.meals.mealsMenu

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerMealsAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
      return 3
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
           0->{
                MealMealsFragment()
           }
           1->{
               SnackMealsFragment()
           }
           2->{
              ComponentMealsFragment()
           }
           else ->{
               Fragment()
           }
       }
    }
}