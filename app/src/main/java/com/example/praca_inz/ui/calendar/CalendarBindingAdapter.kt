package com.example.praca_inz.ui.calendar

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.property.UserProperty

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<UserProperty>?) {
    val adapter = recyclerView.adapter as CalendarGridAdapter
    adapter.submitList(data)
}