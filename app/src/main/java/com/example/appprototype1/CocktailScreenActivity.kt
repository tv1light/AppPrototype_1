package com.example.appprototype1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class CocktailScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail_screen)

        val position = intent.getIntExtra("position", 1)

        val db: DataBase = DataBase.getDB(this)
        val cocktail = db.getDao().getItems().get(position)
        val imageView : ImageView = findViewById(R.id.cocktailScreenIm)
        val textView: TextView = findViewById(R.id.description)
        imageView.setImageResource(cocktail.image)
        setTitle(cocktail.name)
        textView.setText(cocktail.createInstructions)
    }
}