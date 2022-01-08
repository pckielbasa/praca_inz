package com.example.praca_inz.ui.food

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.property.FoodProperty


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<FoodProperty>?) {
    val adapter = recyclerView.adapter as FoodGridAdapter
    adapter.submitList(data)
}