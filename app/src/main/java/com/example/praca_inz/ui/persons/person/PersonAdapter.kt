package com.example.praca_inz.ui.persons.person

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.databinding.PersonRowBinding
import com.example.praca_inz.property.PersonProperty

class PersonAdapter : ListAdapter<PersonProperty, PersonAdapter.PersonPropertyViewHolder>(DiffCallback) {

    class PersonPropertyViewHolder(private var binding: PersonRowBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(marsProperty: PersonProperty) {
            binding.property = marsProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PersonProperty>() {
        override fun areItemsTheSame(oldItem: PersonProperty, newItem: PersonProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PersonProperty, newItem: PersonProperty): Boolean {
            return oldItem.personName == newItem.personName
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonAdapter.PersonPropertyViewHolder {
        return PersonPropertyViewHolder(PersonRowBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PersonAdapter.PersonPropertyViewHolder, position: Int) {
        val personProperty = getItem(position)
        holder.bind(personProperty)
    }
}