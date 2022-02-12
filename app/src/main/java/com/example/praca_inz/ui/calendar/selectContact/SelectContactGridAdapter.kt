package com.example.praca_inz.ui.calendar.selectContact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.databinding.ContactListItemBinding
import com.example.praca_inz.property.MyContactProperty
import com.example.praca_inz.ui.calendar.selectContact.SelectContactGridAdapter.*

class SelectContactGridAdapter (val onClickListener:OnClickListener)
    : ListAdapter<MyContactProperty,
        SelectContactPropertyViewHolder>(DiffCallback) {

    enum class SelectContactApiStatus { LOADING, ERROR, DONE, EMPTY}


    class SelectContactPropertyViewHolder(private var binding: ContactListItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(myContactProperty: MyContactProperty) {
            binding.property = myContactProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MyContactProperty>() {
        override fun areItemsTheSame(oldItem: MyContactProperty, newItem: MyContactProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MyContactProperty, newItem: MyContactProperty): Boolean {
            return oldItem.contactName == newItem.contactName
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectContactPropertyViewHolder {
        return SelectContactPropertyViewHolder(ContactListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: SelectContactPropertyViewHolder,
        position: Int
    ) {
        val myContactProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(myContactProperty)
        }
        holder.bind(myContactProperty)
    }

    class OnClickListener(val clickListener: (myContactProperty: MyContactProperty) -> Unit) {
        fun onClick(myContactProperty: MyContactProperty) = clickListener(myContactProperty)
    }
}