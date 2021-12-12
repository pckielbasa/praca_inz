package com.example.praca_inz.ui.meals

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.lifecycle.Observer
import com.example.praca_inz.databinding.FragmentMealsBinding

class MealsFragment : Fragment() {

    private  lateinit var mealsViewModel: MealsViewModel
    private var _binding: FragmentMealsBinding? =null

    private  val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {

        mealsViewModel =
            ViewModelProvider(this).get(MealsViewModel::class.java)

        _binding = FragmentMealsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMeals
        mealsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}