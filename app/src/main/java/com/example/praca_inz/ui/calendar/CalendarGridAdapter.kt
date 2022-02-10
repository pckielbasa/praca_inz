package com.example.praca_inz.ui.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.databinding.CalendarItemListBinding
import com.example.praca_inz.property.MyDayProperty
import com.example.praca_inz.ui.calendar.CalendarGridAdapter.MyDayPropertyViewHolder


class CalendarGridAdapter(val onClickListener: OnClickListener)
    : ListAdapter<MyDayProperty,
        MyDayPropertyViewHolder>(DiffCallback) {

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
    ): MyDayPropertyViewHolder {
        return MyDayPropertyViewHolder(CalendarItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: MyDayPropertyViewHolder,
        position: Int
    ) {
        val myDayProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(myDayProperty)
        }
        holder.bind(myDayProperty)
    }

    class OnClickListener(val clickListener: (myDayProperty:MyDayProperty) -> Unit) {
        fun onClick(myDayProperty: MyDayProperty) = clickListener(myDayProperty)
    }
}