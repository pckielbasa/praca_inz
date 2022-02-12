package com.example.praca_inz.ui.calendar.selectContact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.praca_inz.R
import com.example.praca_inz.databinding.SelectContactFragmentBinding
import com.example.praca_inz.network.ContactApiFilter
import com.example.praca_inz.ui.contact.ContactGridAdapter

class SelectContactFragment : Fragment() {

    private lateinit var binding:SelectContactFragmentBinding
    private val selectContactViewModel: SelectContactViewModel by lazy {
        ViewModelProvider(this)[SelectContactViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SelectContactFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.selectContactViewModel = selectContactViewModel


        selectContactViewModel.goToAddContact.observe(viewLifecycleOwner, { goOpen ->
            if(goOpen){
                openAddContact()
                selectContactViewModel.addContactFinish()
            }
        })


        binding.selectContactGrid.adapter = ContactGridAdapter(ContactGridAdapter.OnClickListener {
            selectContactViewModel.displayPropertyDetails(it)
        })

        selectContactViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(SelectContactFragmentDirections.actionSelectContactFragmentToAddContactToDayFragment(it))
                selectContactViewModel.displayPropertyDetailsComplete()
            }
        })

        binding.animalButton.setOnClickListener {
            selectContactViewModel.updateFilter(
                ContactApiFilter.SHOW_ANIMAL,
            )
        }
        binding.chemistryButton.setOnClickListener {
            selectContactViewModel.updateFilter(
                ContactApiFilter.SHOW_CHEMISTRY,
            )
        }
        binding.plantButton.setOnClickListener {
            selectContactViewModel.updateFilter(
                ContactApiFilter.SHOW_PLANT,
            )
        }
        return binding.root
    }
    private fun openAddContact(){
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_selectContactFragment_to_addContactFragment)

    }




}