package com.example.appprototype1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class CocktailScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail_screen)
        val cocktail = intent.getParcelableExtra<Item>("cocktail")
        if(cocktail != null)
        {
            val imageView : ImageView = findViewById(R.id.cocktailScreenIm)
            imageView.setImageResource(cocktail.image)
            setTitle(cocktail.name)
        }
    }
}