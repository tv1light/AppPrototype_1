package com.example.appprototype1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appprototype1.databinding.ActivityCockSreenBinding
import com.example.appprototype1.ui.home.HomeFragment

class AddCocktailActivity : AppCompatActivity() {



    private lateinit var binding: ActivityCockSreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cock_sreen)

        val db = DataBase.getDB(HomeFragment())

        binding = ActivityCockSreenBinding.inflate(layoutInflater)

        binding.buttonSave.setOnClickListener {
            val cock = Item(null, binding.edCoct.text.toString(), 0)
            Thread { // Открытие потока для разделения
                db.getDao().insertItem(cock)
            }.start()
            val ing = IngridDataBase(null, binding.edIngr.text.toString(), 100, 0)
            Thread {
                db.getDao().insertIngr(ing)
            }.start()
        }

        binding.buttonNuke.setOnClickListener {
                Thread {
                    db.getDao().nukeTable()
                    db.getDao().nukeIngridTable()
                }.start()
        }
    }
}

