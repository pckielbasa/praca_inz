package com.example.praca_inz.ui.food

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.databinding.FoodListItemBinding
import com.example.praca_inz.property.FoodProperty
import com.example.praca_inz.ui.food.FoodGridAdapter.*

class FoodGridAdapter(private val onClickListener: OnClickListener) : ListAdapter<FoodProperty, FoodPropertyViewHolder>(DiffCallback) {

    enum class FoodGridStatus { LOADING, ERROR, DONE,EMPTY }


    class FoodPropertyViewHolder(private var binding: FoodListItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodProperty: FoodProperty) {
            binding.property = foodProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<FoodProperty>() {
        override fun areItemsTheSame(oldItem: FoodProperty, newItem: FoodProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: FoodProperty, newItem: FoodProperty): Boolean {
            return oldItem.foodName == newItem.foodName
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodPropertyViewHolder {
        return FoodPropertyViewHolder(FoodListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: FoodPropertyViewHolder,
        position: Int
    ) {
        val foodProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(foodProperty)
        }
        holder.bind(foodProperty)
    }

    class OnClickListener(val clickListener: (foodProperty: FoodProperty) -> Unit) {
        fun onClick(foodProperty:FoodProperty) = clickListener(foodProperty)
    }
}