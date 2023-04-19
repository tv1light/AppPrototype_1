package com.example.appprototype1.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.appprototype1.Cocktail
import com.example.appprototype1.R


class CocktailRecipeAdapter(
    private val recipes: ArrayList<Cocktail>,
    private val context: Context?
    ) : RecyclerView.Adapter<CocktailRecipeAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CocktailRecipeAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_item,
            parent, false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CocktailRecipeAdapter.MyViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.courseNameTV.text = recipes.get(position).name
        holder.courseIV.setImageResource(recipes.get(position).image)
    }

    override fun getItemCount(): Int {
        // on below line we are
        // returning our size of our list
        return recipes.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing our course name text view and our image view.
        val courseNameTV: TextView = itemView.findViewById(R.id.textView2)
        val courseIV: ImageView = itemView.findViewById(R.id.imageView)
    }

}


