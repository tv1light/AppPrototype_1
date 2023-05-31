package com.example.appprototype1.ui.ingredients

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.example.appprototype1.*

class IngredientsAdapter(
    private val data: DataBase,
    private val listener: RecyclerViewEvent
) : RecyclerView.Adapter<IngredientsAdapter.ItemViewHolder>() {

    //Setup variables to hold the instance of the views defined in your recyclerView item layout
    //Kinda like the onCreate method in an Activity
    inner class ItemViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        val name: TextView = view.findViewById(R.id.textViewIng)
        val image: ImageView = view.findViewById(R.id.imageViewIng)
        var checkbox: CheckBox = view.findViewById(R.id.ingCheck)

        init {
            view.setOnClickListener(this)
            checkbox.setOnClickListener{
                val coct = data.getDao().getAllIngr().get(adapterPosition)
                data.getDao().updateIngBool(!coct.inBar, coct.id)
            }

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
            .inflate(R.layout.ingredient_item, parent, false)
        return ItemViewHolder(inflatedView)
    }

    // Set values to the views we pulled out of the recycler_view_row
    // layout file based on the position of the recyclerView
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val ingredient = data.getDao().getAllIngr().get(position)
        val b: Boolean = data.getDao().getAllIngr().get(position).inBar
        holder.name.text = ingredient.name
        holder.image.setImageResource(ingredient.image)
        holder.checkbox.isChecked = b
    }

    //The recyclerView just wants to know how many items are currently in your dataset
    override fun getItemCount(): Int {
        var size: Int = 0
        size = data.getDao().getAllIngr().size
        return size
    }

    interface RecyclerViewEvent{
        fun onItemClick(position: Int)
    }
}




