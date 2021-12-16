package com.example.praca_inz.ui.allergies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.authorization.login.LoginViewModel
import com.example.praca_inz.databinding.FragmentAllergiesBinding
import com.example.praca_inz.databinding.FragmentLoginBinding
import com.example.praca_inz.ui.allergies.allergiesMenu.ViewPagerAllergiesAdapter
import com.example.praca_inz.ui.meals.mealsMenu.ViewPagerMealsAdapter
import com.google.android.material.tabs.TabLayoutMediator


class AllergiesFragment : Fragment() {

    private val allergiesViewModel: AllergiesViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, AllergiesViewModel.AllergiesViewModelFactory(activity.application))[AllergiesViewModel::class.java]
    }

    private lateinit var binding: FragmentAllergiesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllergiesBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        //Menu Allergies
        val tabLayout = binding.tabLayoutAllergies
        val viewPager2 = binding.viewPagerAllergies
        val adapter= ViewPagerAllergiesAdapter(requireActivity().supportFragmentManager, lifecycle)

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

//        binding.allergiesViewModel = allergiesViewModel
        return binding.root
    }


}