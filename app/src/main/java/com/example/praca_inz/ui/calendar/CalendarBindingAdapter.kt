package com.example.praca_inz.ui.calendar

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.R
import com.example.praca_inz.property.MyDayProperty
import com.example.praca_inz.ui.calendar.CalendarViewModel.MyDayStatus

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MyDayProperty>?) {
    val adapter = recyclerView.adapter as CalendarGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView, status: MyDayStatus?) {
    when (status) {
        MyDayStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        MyDayStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_cloud_off)
        }
        MyDayStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        MyDayStatus.EMPTY -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_empty)
        }
    }
}
@BindingAdapter("calendarApiStatus")
fun bindStatus(staTextView: TextView, status: MyDayStatus?) {
    when (status) {
        MyDayStatus.LOADING -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text = "Loading..."
        }
        MyDayStatus.ERROR -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text = "Connect Error!!! "
        }

        MyDayStatus.DONE -> {
            staTextView.visibility = TextView.GONE
        }
        MyDayStatus.EMPTY -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text="List is empty."
        }
    }
}