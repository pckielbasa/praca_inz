package com.example.praca_inz.ui.calendar.selectContact

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.R
import com.example.praca_inz.property.MyContactProperty
import com.example.praca_inz.ui.calendar.selectContact.SelectContactGridAdapter
import com.example.praca_inz.ui.calendar.selectContact.SelectContactGridAdapter.*
import com.example.praca_inz.ui.contact.ContactGridAdapter.ContactApiStatus


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MyContactProperty>?) {
    val adapter = recyclerView.adapter as SelectContactGridAdapter
    adapter.submitList(data)
}
@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView, status: SelectContactApiStatus?) {
    when (status) {
        SelectContactApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        SelectContactApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_cloud_off)
        }
        SelectContactApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        SelectContactApiStatus.EMPTY -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_empty)
        }
    }
}
@BindingAdapter("contactApiStatus")
fun bindStatus(staTextView: TextView, status: SelectContactApiStatus?) {
    when (status) {
        SelectContactApiStatus.LOADING -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text = "Loading..."
        }
        SelectContactApiStatus.ERROR -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text = "Connect Error!!! "
        }

        SelectContactApiStatus.DONE -> {
            staTextView.visibility = TextView.GONE
        }
        SelectContactApiStatus.EMPTY -> {
            staTextView.visibility = TextView.VISIBLE
            staTextView.text="List is empty."
        }
    }
}
