package com.example.praca_inz.authorization

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.praca_inz.authorization.login.LoginFragment
import com.example.praca_inz.authorization.registration.RegistrationFragment
import com.example.praca_inz.ui.meals.mealsMenu.component.ComponentMealsFragment
import com.example.praca_inz.ui.meals.mealsMenu.meal.MealMealsFragment
import com.example.praca_inz.ui.meals.mealsMenu.snack.SnackMealsFragment

class ViewPagerAuthAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                LoginFragment()
            }
            1->{
                RegistrationFragment()
            }
            else ->{
                Fragment()
            }
        }
    }
}