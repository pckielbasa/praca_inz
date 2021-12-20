package com.example.praca_inz.authorization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.praca_inz.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class AuthorizationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authorization_activity)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayoutLogin)
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPagerLogin)
        val adapter= ViewPagerAuthAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter=adapter
        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            when(position){
                0->{
                    tab.text="Login"
                }
                1->{
                    tab.text="Registration"
                }
            }
        }.attach()
    }
}