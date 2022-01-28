package com.example.praca_inz.ui.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.praca_inz.R
import com.example.praca_inz.databinding.FragmentContactBinding
import com.example.praca_inz.network.ContactApiFilter
import com.example.praca_inz.network.UserFilter
import com.example.praca_inz.ui.contact.addContact.AddContactFragment
import com.example.praca_inz.ui.food.FoodFragmentDirections
import com.example.praca_inz.ui.food.FoodGridAdapter


class ContactFragment : Fragment() {

    private val contactViewModel: ContactViewModel by lazy {
        ViewModelProvider(this)[ContactViewModel::class.java]
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


        binding.contactGrid.adapter = ContactGridAdapter(ContactGridAdapter.OnClickListener {
            contactViewModel.displayPropertyDetails(it)
        })

        contactViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(ContactFragmentDirections.actionNavigationContactToDetailContactFragment(it))
                contactViewModel.displayPropertyDetailsComplete()
            }
        })

        binding.animalButton.setOnClickListener {
            contactViewModel.updateFilter(
                    ContactApiFilter.SHOW_ANIMAL,
                    UserFilter.SHOW_USER
            )
        }
        binding.chemistryButton.setOnClickListener {
            contactViewModel.updateFilter(
                ContactApiFilter.SHOW_CHEMISTRY,
                UserFilter.SHOW_USER
            )
        }
        binding.plantButton.setOnClickListener {
            contactViewModel.updateFilter(
                ContactApiFilter.SHOW_PLANT,
                UserFilter.SHOW_USER
            )
        }
        return binding.root
    }
    private fun openAddContact(){
        val dialog = AddContactFragment()
        dialog.show(requireActivity().supportFragmentManager, "ADD CONTACT THINGS")

    }




}