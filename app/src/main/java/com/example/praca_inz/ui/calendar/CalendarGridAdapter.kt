package com.example.praca_inz.ui.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.databinding.CalendarItemListBinding
import com.example.praca_inz.property.MyDayProperty


class CalendarGridAdapter : ListAdapter<MyDayProperty, CalendarGridAdapter.MyDayPropertyViewHolder>(DiffCallback) {
    enum class CalendarApiStatus { LOADING, ERROR, DONE,EMPTY }
    class MyDayPropertyViewHolder(private var binding: CalendarItemListBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(myDayProperty: MyDayProperty) {
            binding.property = myDayProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MyDayProperty>() {
        override fun areItemsTheSame(oldItem: MyDayProperty, newItem: MyDayProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MyDayProperty, newItem: MyDayProperty): Boolean {
            return oldItem.hour == newItem.hour
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CalendarGridAdapter.MyDayPropertyViewHolder {
        return MyDayPropertyViewHolder(CalendarItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: CalendarGridAdapter.MyDayPropertyViewHolder,
        position: Int
    ) {
        val myDayProperty = getItem(position)
        holder.bind(myDayProperty)
    }

}