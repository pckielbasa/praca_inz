package com.example.praca_inz.ui.food.components

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.R

class ComponentFragment : Fragment() {

    companion object {
        fun newInstance() = ComponentFragment()
    }

    private lateinit var viewModel: ComponentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.component_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ComponentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}