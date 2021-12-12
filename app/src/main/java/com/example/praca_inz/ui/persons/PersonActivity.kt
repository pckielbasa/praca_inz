package com.example.praca_inz.ui.persons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.praca_inz.R

class PersonActivity : AppCompatActivity() {
    private val viewModel: PersonActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)
    }
}