package com.example.praca_inz.ui.meals.addMeals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.praca_inz.R
import com.example.praca_inz.databinding.FragmentAddMealsBinding
import com.example.praca_inz.databinding.FragmentAddPersonBinding
import com.example.praca_inz.ui.persons.addPerson.AddPersonViewModel

class AddMealsFragment : Fragment() {

    private val addMealsViewModel: AddMealsViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, AddMealsViewModel.AddMealsViewModelFactory(activity.application)).get(
            AddMealsViewModel::class.java)
    }

    private lateinit var binding: FragmentAddMealsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddMealsBinding.inflate(inflater, container, false)
//        binding.lifecycleOwner = this
//        binding.addMealsViewModel = addMealsViewModel

        return binding.root
    }


}