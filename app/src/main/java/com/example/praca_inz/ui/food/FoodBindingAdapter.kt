package com.example.praca_inz.ui.food

import android.view.View
import android.widget.ImageView
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
            statusImageView.setImageResource(R.drawable.ic_change)
        }
        FoodGridAdapter.FoodGridStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_cloud_off)
        }
        FoodGridAdapter.FoodGridStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}