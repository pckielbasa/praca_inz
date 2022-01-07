package com.example.praca_inz.ui.food

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.databinding.FragmentFoodBinding
import com.example.praca_inz.ui.food.addFood.AddFoodFragment
import com.google.android.material.tabs.TabLayoutMediator

class FoodFragment : Fragment() {

    private val foodViewModel: FoodViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, FoodViewModel.FoodViewModelFactory(activity.application))[FoodViewModel::class.java]
    }

    private lateinit var binding: FragmentFoodBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFoodBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.foodViewModel = foodViewModel

        foodViewModel.eventOpenPopupMenu.observe(viewLifecycleOwner, { goOpen ->
            if(goOpen){
                openAddContact()
                foodViewModel.openPopupMenuFinished()
            }
        })

        //Tabs
        val tabLayout = binding.tabLayoutFood
        val viewPager2 = binding.viewPagerFood
        val adapter= ViewPagerFoodAdapter(requireActivity().supportFragmentManager, lifecycle)
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

    fun openAddContact(){
        val dialog = AddFoodFragment()
        dialog.show(requireActivity().supportFragmentManager, "ADD CONTACT THINGS")

    }
}