package com.example.appprototype1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.appprototype1.DataBase.Companion.getDB

class IngredientScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient_screen)
        val position = intent.getIntExtra("ingredient", 0)
        val db: DataBase = getDB(this)
        val ingredient = db.getDao().getAllIngr().get(position)
        val imageView : ImageView = findViewById(R.id.ingredientScreenIM)
        imageView.setImageResource(ingredient.image)
        title = ingredient.name
    }
}