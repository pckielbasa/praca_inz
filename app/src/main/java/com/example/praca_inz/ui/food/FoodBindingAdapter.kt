package com.example.praca_inz.ui.food

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.R
import com.example.praca_inz.property.MyFoodProperty
import com.example.praca_inz.ui.food.FoodGridAdapter.FoodGridStatus


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MyFoodProperty>?) {
    val adapter = recyclerView.adapter as FoodGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView, status: FoodGridStatus?) {
    when (status) {
        FoodGridStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        FoodGridStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_cloud_off)
        }
        FoodGridStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        FoodGridStatus.EMPTY -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_empty)
        }
    }
}
@BindingAdapter("foodApiStatus")
fun bindStatus(staTextView: TextView, status: FoodGridStatus?) {
    when (status) {
        FoodGridStatus.LOADING -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text = "Loading..."
        }
        FoodGridStatus.ERROR -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text = "Connect Error!!! "
        }

        FoodGridStatus.DONE -> {
        staTextView.visibility = TextView.GONE
        }
        FoodGridStatus.EMPTY -> {
        staTextView.visibility = TextView.VISIBLE
        staTextView.text="List is empty."
        }
    }
}