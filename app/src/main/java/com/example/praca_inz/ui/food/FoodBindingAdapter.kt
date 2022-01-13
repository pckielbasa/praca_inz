package com.example.praca_inz.ui.food

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.R
import com.example.praca_inz.property.FoodProperty
import com.example.praca_inz.ui.contact.ContactGridAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<FoodProperty>?) {
    val adapter = recyclerView.adapter as FoodGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView, status: FoodGridAdapter.FoodGridStatus?) {
    when (status) {
        FoodGridAdapter.FoodGridStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        FoodGridAdapter.FoodGridStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_cloud_off)
        }
        FoodGridAdapter.FoodGridStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        FoodGridAdapter.FoodGridStatus.EMPTY -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_empty)
        }
    }
}
@BindingAdapter("foodApiStatus")
fun bindStatus(staTextView: TextView, status: FoodGridAdapter.FoodGridStatus?) {
    when (status) {
        FoodGridAdapter.FoodGridStatus.LOADING -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text = "Loading..."
        }
        FoodGridAdapter.FoodGridStatus.ERROR -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text = "Connect Error!!! "
        }

        FoodGridAdapter.FoodGridStatus.DONE -> {
        staTextView.visibility = TextView.GONE
        }
        FoodGridAdapter.FoodGridStatus.EMPTY -> {
        staTextView.visibility = TextView.VISIBLE
        staTextView.text="List is empty."
        }
    }
}