package com.example.praca_inz.ui.contact

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.property.ContactProperty


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ContactProperty>?) {
    val adapterChemistry = recyclerView.adapter as ContactGridAdapter
    adapterChemistry.submitList(data)
}