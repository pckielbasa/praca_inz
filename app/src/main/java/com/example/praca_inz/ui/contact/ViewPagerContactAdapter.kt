package com.example.praca_inz.ui.contact

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.praca_inz.ui.contact.animal.AnimalFragment
import com.example.praca_inz.ui.contact.chemistry.ChemistryFragment
import com.example.praca_inz.ui.contact.plant.PlantFragment

class ViewPagerContactAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                ChemistryFragment()
            }
            1->{
                PlantFragment()
            }
            2->{
                AnimalFragment()
            }
            else ->{
                Fragment()
            }
        }
    }
}