package com.example.praca_inz.ui.food

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.praca_inz.ui.food.components.ComponentFragment
import com.example.praca_inz.ui.food.meals.MealFragment
import com.example.praca_inz.ui.food.snacks.SnackFragment

class ViewPagerFoodAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                MealFragment()
            }
            1->{
                SnackFragment()
            }
            2->{
                ComponentFragment()
            }
            else ->{
                Fragment()
            }
        }
    }
}