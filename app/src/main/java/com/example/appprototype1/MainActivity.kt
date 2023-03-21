package com.example.appprototype1

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appprototype1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //vlad molodec

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DataBase.getDB(this)

        val it = Item(null,"Bloody Mary", "Vodka") //тестовая херь, думаю будет удобнее её в отдельное окно вынести


        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_ingredients,
                //brbrbrbrbrb
                R.id.navigation_cart, R.id.navigation_favorites,
                R.id.navigation_menu
            )

        )



        //vlad horoshiy
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}
