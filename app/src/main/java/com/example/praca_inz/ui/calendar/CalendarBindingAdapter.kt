package com.example.praca_inz.ui.calendar

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.R
import com.example.praca_inz.property.UserProperty
import com.example.praca_inz.ui.calendar.CalendarViewModel.CalendarStatus
import com.example.praca_inz.ui.food.FoodGridAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<UserProperty>?) {
    val adapter = recyclerView.adapter as CalendarGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView, status: CalendarStatus?) {
    when (status) {
        CalendarStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        CalendarStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_cloud_off)
        }
        CalendarStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        CalendarStatus.EMPTY -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_empty)
        }
    }
}
@BindingAdapter("calendarApiStatus")
fun bindStatus(staTextView: TextView, status: CalendarStatus?) {
    when (status) {
        CalendarStatus.LOADING -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text = "Loading..."
        }
        CalendarStatus.ERROR -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text = "Connect Error!!! "
        }

        CalendarStatus.DONE -> {
            staTextView.visibility = TextView.GONE
        }
        CalendarStatus.EMPTY -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text="List is empty."
        }
    }
}