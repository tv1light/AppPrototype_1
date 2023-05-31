package com.example.appprototype1.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.appprototype1.*

class CarAdapter(
    private val data: DataBase,
    private val listener: RecyclerViewEvent
) : RecyclerView.Adapter<CarAdapter.ItemViewHolder>() {

    //Setup variables to hold the instance of the views defined in your recyclerView item layout
    //Kinda like the onCreate method in an Activity
    inner class ItemViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener, View.OnLongClickListener {
        val name: TextView = view.findViewById(R.id.textViewIng)
        val image: ImageView = view.findViewById(R.id.imageViewIng)

        init {
            view.setOnClickListener(this)
            view.setOnLongClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

        override fun onLongClick(p0: View?): Boolean {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                listener.onItemLongClick(position)
            }
            return true
        }
    }
    //This is where you inflate the layout (Give each entry/row its look)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflatedView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_item, parent, false)
        return ItemViewHolder(inflatedView)
    }

    // Set values to the views we pulled out of the recycler_view_row
    // layout file based on the position of the recyclerView
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val ingredient: IngridDataBase = data.getDao().getAllIngr().get(position)
        holder.name.text = ingredient.name
        holder.image.setImageResource(ingredient.image)
    }

    //The recyclerView just wants to know how many items are currently in your dataset
    override fun getItemCount(): Int {
        return data.getDao().getAllIngr().size
    }

    interface RecyclerViewEvent{
        fun onItemClick(position: Int)
        fun onItemLongClick(position: Int)
    }
}



