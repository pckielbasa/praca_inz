package com.example.praca_inz.ui.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.databinding.FragmentDayBinding
import com.example.praca_inz.property.UserProperty

class CalendarGridAdapter : ListAdapter<UserProperty, CalendarGridAdapter.UserPropertyViewHolder>(DiffCallback) {
    class UserPropertyViewHolder(private var binding: FragmentDayBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userProperty: UserProperty) {
            binding.property = userProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<UserProperty>() {
        override fun areItemsTheSame(oldItem: UserProperty, newItem: UserProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: UserProperty, newItem: UserProperty): Boolean {
            return oldItem.username == newItem.username
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CalendarGridAdapter.UserPropertyViewHolder {
        return UserPropertyViewHolder(FragmentDayBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: CalendarGridAdapter.UserPropertyViewHolder,
        position: Int
    ) {
        val userProperty = getItem(position)
        holder.bind(userProperty)
    }

}