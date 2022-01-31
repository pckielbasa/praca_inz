package com.example.praca_inz.ui.contact

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.R
import com.example.praca_inz.property.ContactProperty
import com.example.praca_inz.property.MyContactProperty
import com.example.praca_inz.ui.contact.ContactGridAdapter.ContactApiStatus
import com.example.praca_inz.ui.food.FoodGridAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MyContactProperty>?) {
    val adapter = recyclerView.adapter as ContactGridAdapter
    adapter.submitList(data)
}
@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView, status: ContactApiStatus?) {
    when (status) {
        ContactApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ContactApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_cloud_off)
        }
        ContactApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        ContactApiStatus.EMPTY -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_empty)
        }
    }
}
@BindingAdapter("contactApiStatus")
fun bindStatus(staTextView: TextView, status: ContactApiStatus?) {
    when (status) {
        ContactApiStatus.LOADING -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text = "Loading..."
        }
        ContactApiStatus.ERROR -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text = "Connect Error!!! "
        }

        ContactApiStatus.DONE -> {
            staTextView.visibility = TextView.GONE
        }
        ContactApiStatus.EMPTY -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text="List is empty."
        }
    }
}
