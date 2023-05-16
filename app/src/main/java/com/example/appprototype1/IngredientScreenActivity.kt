package com.example.appprototype1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class IngredientScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient_screen)
        val ingredient = intent.getParcelableExtra<Ingredient>("ingredient")
        if(ingredient != null)
        {
            val imageView : ImageView = findViewById(R.id.ingredientScreenIM)
            imageView.setImageResource(ingredient.image)

            setTitle(ingredient.name)
        }
    }
}