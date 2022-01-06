package com.example.praca_inz


import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.property.PersonProperty
import com.example.praca_inz.ui.persons.person.PersonAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<PersonProperty>?) {
    val adapter = recyclerView.adapter as PersonAdapter
    adapter.submitList(data)
}