package com.example.praca_inz.ui.contact

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.property.ContactProperty
import com.example.praca_inz.ui.contact.animal.AnimalGridAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ContactProperty>?) {
    val adapter = recyclerView.adapter as AnimalGridAdapter
    adapter.submitList(data)
}