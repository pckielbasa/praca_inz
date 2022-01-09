package com.example.praca_inz.ui.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.databinding.FragmentContactBinding
import com.example.praca_inz.ui.contact.addContact.AddContactFragment


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


        binding.contactGrid.adapter = ContactGridAdapter()

        return binding.root
    }
    private fun openAddContact(){
        val dialog = AddContactFragment()
        dialog.show(requireActivity().supportFragmentManager, "ADD CONTACT THINGS")

    }


}