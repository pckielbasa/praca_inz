package com.example.praca_inz.ui.meals.mealsMenu.meal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.databinding.MealRowBinding
import com.example.praca_inz.network.MealProperty

class MealAdapter : ListAdapter<MealProperty, MealAdapter.MealPropertyViewHolder>(DiffCallback) {

    class MealPropertyViewHolder(private var binding: MealRowBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mealProperty: MealProperty) {
            binding.property = mealProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MealProperty>() {
        override fun areItemsTheSame(oldItem: MealProperty, newItem: MealProperty): Boolean {
            return oldItem.username === newItem.username
        }

        override fun areContentsTheSame(oldItem: MealProperty, newItem: MealProperty): Boolean {
            return oldItem.username == newItem.username
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MealAdapter.MealPropertyViewHolder {
        return MealPropertyViewHolder(MealRowBinding.inflate(LayoutInflater.from(parent.context)))
    }


    override fun onBindViewHolder(holder: MealAdapter.MealPropertyViewHolder, position: Int) {
        val mealProperty = getItem(position)
        holder.bind(mealProperty)
    }
}