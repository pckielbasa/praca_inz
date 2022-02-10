package com.example.praca_inz.ui.allergies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.databinding.AllergiesListItemBinding
import com.example.praca_inz.property.MyAllergiesProperty
import com.example.praca_inz.ui.allergies.AllergiesGridAdapter.AllergiesPropertyViewHolder

class AllergiesGridAdapter(private val onClickListener: OnClickListener) : ListAdapter<MyAllergiesProperty, AllergiesPropertyViewHolder>(DiffCallback) {

    enum class AllergiesGridStatus { LOADING, ERROR, DONE,EMPTY }


    class AllergiesPropertyViewHolder(private var binding: AllergiesListItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(myAllergiesProperty: MyAllergiesProperty) {
            binding.property = myAllergiesProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MyAllergiesProperty>() {
        override fun areItemsTheSame(oldItem: MyAllergiesProperty, newItem: MyAllergiesProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MyAllergiesProperty, newItem: MyAllergiesProperty): Boolean {
            return oldItem.allergiesName == newItem.allergiesName
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AllergiesPropertyViewHolder {
        return AllergiesPropertyViewHolder(AllergiesListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: AllergiesPropertyViewHolder,
        position: Int
    ) {
        val myAllergiesProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(myAllergiesProperty)
        }
        holder.bind(myAllergiesProperty)
    }

    class OnClickListener(val clickListener: (myAllergiesProperty: MyAllergiesProperty) -> Unit) {
        fun onClick(myAllergiesProperty:MyAllergiesProperty) = clickListener(myAllergiesProperty)
    }


}