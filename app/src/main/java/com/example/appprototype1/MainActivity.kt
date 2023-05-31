package com.example.appprototype1

import android.os.Bundle
import android.view.Menu
import android.view.SearchEvent
import android.widget.SearchView
import androidx.activity.compose.setContent
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.splashscreen.SplashScreenViewProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appprototype1.databinding.ActivityMainBinding
import com.example.appprototype1.ui.cart.CartFragment
import com.example.appprototype1.ui.home.HomeFragment
import kotlin.concurrent.thread


@Suppress("NAME_SHADOWING")
open class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        ingredientsInit()
        cocktailsInit()
        installSplashScreen().apply { }
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_ingredients,
                R.id.navigation_cart, R.id.navigation_favorites,
                R.id.navigation_menu
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        val search = menu?.findItem(R.id.nav_search)
        val searchView = search?.actionView as SearchView
        searchView.queryHint = "Input request"
        return super.onCreateOptionsMenu(menu)
    }

    fun ingredientsInit()
    {
        val ingList: DataBase = DataBase.getDB(this)

            val db = ingList.getDao()
            if(db.getAllIngr().size == 0) {
                db.insertIngr(IngridDataBase(0, "Lemon", R.drawable.lemon, 0, true))
                db.insertIngr(IngridDataBase(1, "Orange", R.drawable.orange, 0, false))
//                db.insertIngr(IngridDataBase(null, "Whiskey", R.drawable.whiskey))
//                db.insertIngr(IngridDataBase(null, "Jagermeister", R.drawable.jeger))
//                db.insertIngr(IngridDataBase(null, "Coke", R.drawable.cocke))
//                db.insertIngr(IngridDataBase(0, "Lemon", R.drawable.lemon))
//                db.insertIngr(IngridDataBase(0, "Whiskey", R.drawable.whiskey))
            }
    }
    private fun cocktailsInit(){
        val cockList: DataBase = DataBase.getDB(this)

            val db = cockList.getDao()
            if(db.getItems().size == 0) {
                db.insertItem(Item(null, "Long Island Iced Tea", R.drawable.cock2))
                db.insertItem(Item(null, "Old Fashioned", R.drawable.cock4))
                db.insertItem(Item(null, "Margarita", R.drawable.cock3))
                db.insertItem(Item(null, "Electric fizz", R.drawable.splash))
                db.insertItem(Item(null, "Gray Hound", R.drawable.cock1))
            }

    }
}