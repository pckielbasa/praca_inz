package com.example.praca_inz

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.network.MealProperty
import com.example.praca_inz.ui.meals.mealsMenu.meal.MealAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MealProperty>?) {
    val adapter = recyclerView.adapter as MealAdapter
    adapter.submitList(data)
}