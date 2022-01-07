package com.example.praca_inz.ui.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.databinding.FragmentContactBinding
import com.example.praca_inz.ui.contact.addContact.AddContactFragment
import com.google.android.material.tabs.TabLayoutMediator

class ContactFragment : Fragment() {

    private val contactViewModel: ContactViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, ContactViewModel.ContactViewModelFactory(activity.application))[ContactViewModel::class.java]
    }

    private lateinit var binding: FragmentContactBinding


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {

        binding = FragmentContactBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.contactViewModel = contactViewModel


        contactViewModel.eventOpenPopupMenu.observe(viewLifecycleOwner, { goOpen ->
            if(goOpen){
                openAddContact()
                contactViewModel.openPopupMenuFinished()
            }
        })

        //Menu Meals
        val tabLayout = binding.tabLayoutContact
        val viewPager2 = binding.viewPagerContact
        val adapter= ViewPagerContactAdapter(requireActivity().supportFragmentManager, lifecycle)
        viewPager2.adapter=adapter
        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            when(position){
                0->{
                    tab.text="Chemistry"
                }
                1->{
                    tab.text="Plant"
                }
                2->{
                    tab.text="Animal"
                }
            }
        }.attach()


        return binding.root
    }
    fun openAddContact(){
        val dialog = AddContactFragment()
        dialog.show(requireActivity().supportFragmentManager, "ADD CONTACT THINGS")

    }


}