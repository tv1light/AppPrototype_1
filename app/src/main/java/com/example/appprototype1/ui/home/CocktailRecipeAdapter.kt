package com.example.appprototype1.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.appprototype1.DataBase
import com.example.appprototype1.R

class CocktailRecipeAdapter(
    private val data: DataBase,
    private val listener: RecyclerViewEvent
) : RecyclerView.Adapter<CocktailRecipeAdapter.ItemViewHolder>() {

    //Setup variables to hold the instance of the views defined in your recyclerView item layout
    //Kinda like the onCreate method in an Activity
    inner class ItemViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        val name: TextView = view.findViewById(R.id.textView2)
        val image: ImageView = view.findViewById(R.id.imageView)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    //This is where you inflate the layout (Give each entry/row its look)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflatedView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)
        return ItemViewHolder(inflatedView)
    }

    // Set values to the views we pulled out of the recycler_view_row
    // layout file based on the position of the recyclerView
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var cocktailName : String = ""
        var cocktailImg : Int = 0
        cocktailName = data.getDao().getItems().get(position).name
        cocktailImg = data.getDao().getItems().get(position).image
        holder.name.text = cocktailName
        holder.image.setImageResource(cocktailImg)
    }

    //The recyclerView just wants to know how many items are currently in your dataset
    override fun getItemCount(): Int {
        var size: Int = 0
        size = data.getDao().getItems().size
        return size
    }

    interface RecyclerViewEvent{
        fun onItemClick(position: Int)
    }
}
