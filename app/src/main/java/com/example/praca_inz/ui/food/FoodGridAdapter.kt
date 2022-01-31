package com.example.praca_inz.ui.food

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praca_inz.databinding.FoodListItemBinding
import com.example.praca_inz.property.MyFoodProperty
import com.example.praca_inz.ui.food.FoodGridAdapter.FoodPropertyViewHolder

class FoodGridAdapter(private val onClickListener: OnClickListener) : ListAdapter<MyFoodProperty, FoodPropertyViewHolder>(DiffCallback) {

    enum class FoodGridStatus { LOADING, ERROR, DONE,EMPTY }


    class FoodPropertyViewHolder(private var binding: FoodListItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(myFoodProperty: MyFoodProperty) {
            binding.property = myFoodProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MyFoodProperty>() {
        override fun areItemsTheSame(oldItem: MyFoodProperty, newItem: MyFoodProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MyFoodProperty, newItem: MyFoodProperty): Boolean {
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
        val myFoodProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(myFoodProperty)
        }
        holder.bind(myFoodProperty)
    }

    class OnClickListener(val clickListener: (myFoodProperty: MyFoodProperty) -> Unit) {
        fun onClick(myFoodProperty:MyFoodProperty) = clickListener(myFoodProperty)
    }
}