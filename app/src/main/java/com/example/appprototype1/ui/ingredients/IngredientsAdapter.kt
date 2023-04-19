package com.example.appprototype1.ui.ingredients

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.appprototype1.R
import com.example.appprototype1.Ingredient


class IngredientsAdapter(
    private val ingList: ArrayList<Ingredient>,
    private val context: Context?
    ) : RecyclerView.Adapter<IngredientsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IngredientsAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.ingredient_item,
            parent, false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: IngredientsAdapter.MyViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.ingredientTV.text = ingList.get(position).name
        holder.ingredientIV.setImageResource(ingList.get(position).image)
    }

    override fun getItemCount(): Int {
        // on below line we are
        // returning our size of our list
        return ingList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing our course name text view and our image view.
        val ingredientTV: TextView = itemView.findViewById(R.id.textViewIng)
        val ingredientIV: ImageView = itemView.findViewById(R.id.imageViewIng)
    }

}



