package com.example.praca_inz.ui.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.databinding.ContactListItemBinding
import com.example.praca_inz.property.ContactProperty
import com.example.praca_inz.property.FoodProperty
import com.example.praca_inz.property.MyContactProperty
import com.example.praca_inz.ui.food.FoodGridAdapter

class ContactGridAdapter(val onClickListener:ContactGridAdapter.OnClickListener)  : ListAdapter<MyContactProperty, ContactGridAdapter.ContactPropertyViewHolder>(DiffCallback) {

    enum class ContactApiStatus { LOADING, ERROR, DONE, EMPTY}



    class ContactPropertyViewHolder(private var binding: ContactListItemBinding):
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
    ): ContactGridAdapter.ContactPropertyViewHolder {
        return ContactPropertyViewHolder(ContactListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: ContactGridAdapter.ContactPropertyViewHolder,
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