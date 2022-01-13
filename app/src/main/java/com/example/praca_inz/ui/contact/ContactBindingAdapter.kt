package com.example.praca_inz.ui.contact

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.R
import com.example.praca_inz.property.ContactProperty
import com.example.praca_inz.ui.food.FoodGridAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ContactProperty>?) {
    val adapter = recyclerView.adapter as ContactGridAdapter
    adapter.submitList(data)
}
@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView, status: ContactGridAdapter.ContactApiStatus?) {
    when (status) {
        ContactGridAdapter.ContactApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ContactGridAdapter.ContactApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_cloud_off)
        }
        ContactGridAdapter.ContactApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        ContactGridAdapter.ContactApiStatus.EMPTY -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_empty)
        }
    }
}
