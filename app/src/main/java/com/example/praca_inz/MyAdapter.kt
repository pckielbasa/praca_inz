package com.example.praca_inz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val mealsList: ArrayList<TestClass>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.meal_row,parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = mealsList[position]
        holder.tvMealsName.text = currentItem.mealsName
        holder.tvComponentsName.text = currentItem.componentsMeals
    }

    override fun getItemCount(): Int {
        return mealsList.size
    }

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val tvMealsName : TextView = itemView.findViewById(R.id.tvMealName)
        val tvComponentsName : TextView = itemView.findViewById(R.id.tvComponentsName)
    }




}