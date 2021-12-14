package com.example.praca_inz.ui.calendar.addItems

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.example.praca_inz.databinding.FragmentAddItemsBinding


class AddItemsFragment : Fragment() {

    private val addItemsViewModel: AddItemsViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, AddItemsViewModel.AddItemsViewModelFactory(activity.application))[AddItemsViewModel::class.java]
    }

    private lateinit var binding: FragmentAddItemsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddItemsBinding.inflate(inflater, container, false)
//        binding.lifecycleOwner = this
//        binding.addItemsViewModel = addItemsViewModel

        return binding.root
    }

}