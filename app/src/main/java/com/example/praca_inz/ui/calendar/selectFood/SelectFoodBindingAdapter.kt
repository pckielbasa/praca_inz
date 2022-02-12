package com.example.praca_inz.ui.calendar.selectFood


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.R
import com.example.praca_inz.property.MyFoodProperty
import com.example.praca_inz.ui.calendar.selectFood.SelectFoodGridAdapter.*


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MyFoodProperty>?) {
    val adapter = recyclerView.adapter as SelectFoodGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView, status: SelectFoodGridStatus?) {
    when (status) {
        SelectFoodGridStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        SelectFoodGridStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_cloud_off)
        }
        SelectFoodGridStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        SelectFoodGridStatus.EMPTY -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_empty)
        }
    }
}
@BindingAdapter("foodApiStatus")
fun bindStatus(staTextView: TextView, status: SelectFoodGridStatus?) {
    when (status) {
        SelectFoodGridStatus.LOADING -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text = "Loading..."
        }
        SelectFoodGridStatus.ERROR -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text = "Connect Error!!! "
        }

        SelectFoodGridStatus.DONE -> {
            staTextView.visibility = TextView.GONE
        }
        SelectFoodGridStatus.EMPTY -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text="List is empty."
        }
    }
}