package com.example.praca_inz.ui.contact.animal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.databinding.ContactListItemBinding
import com.example.praca_inz.property.ContactProperty

class AnimalGridAdapter : ListAdapter<ContactProperty, AnimalGridAdapter.ContactPropertyViewHolder>(DiffCallback) {

    class ContactPropertyViewHolder(private var binding: ContactListItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contactProperty: ContactProperty) {
            binding.property = contactProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ContactProperty>() {
        override fun areItemsTheSame(oldItem: ContactProperty, newItem: ContactProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ContactProperty, newItem: ContactProperty): Boolean {
            return oldItem.contactName == newItem.contactName
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimalGridAdapter.ContactPropertyViewHolder {
        return ContactPropertyViewHolder(ContactListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: AnimalGridAdapter.ContactPropertyViewHolder,
        position: Int
    ) {
        val contactProperty = getItem(position)
        holder.bind(contactProperty)
    }
}