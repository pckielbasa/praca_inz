package com.example.praca_inz.ui.food.snacks

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praca_inz.R

class SnackFragment : Fragment() {

    companion object {
        fun newInstance() = SnackFragment()
    }

    private lateinit var viewModel: SnackViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.snack_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SnackViewModel::class.java)
        // TODO: Use the ViewModel
    }

}