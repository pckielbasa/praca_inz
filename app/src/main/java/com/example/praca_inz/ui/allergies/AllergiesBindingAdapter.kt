package com.example.praca_inz.ui.allergies


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.R
import com.example.praca_inz.property.MyAllergiesProperty
import com.example.praca_inz.ui.allergies.AllergiesGridAdapter.AllergiesGridStatus


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MyAllergiesProperty>?) {
    val adapter = recyclerView.adapter as AllergiesGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView, status: AllergiesGridStatus?) {
    when (status) {
        AllergiesGridStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        AllergiesGridStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_cloud_off)
        }
        AllergiesGridStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        AllergiesGridStatus.EMPTY -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_empty)
        }
    }
}
@BindingAdapter("allergiesApiStatus")
fun bindStatus(staTextView: TextView, status: AllergiesGridStatus?) {
    when (status) {
        AllergiesGridStatus.LOADING -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text = "Loading..."
        }
        AllergiesGridStatus.ERROR -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text = "Connect Error!!! "
        }

        AllergiesGridStatus.DONE -> {
            staTextView.visibility = TextView.GONE
        }
        AllergiesGridStatus.EMPTY -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text="List is empty."
        }
    }
}