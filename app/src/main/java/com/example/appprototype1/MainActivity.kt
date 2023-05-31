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
                db.insertIngr(IngridDataBase(2, "Whiskey", R.drawable.whiskey, 0, false))
                db.insertIngr(IngridDataBase(3, "Jagermeister", R.drawable.jeger))
                db.insertIngr(IngridDataBase(4, "Coke", R.drawable.cocke))
            }
    }
    private fun cocktailsInit(){
        val cockList: DataBase = DataBase.getDB(this)
//            var lst = ArrayList<Int>()
//            lst.add(0)
//            lst.add(1)
            val db = cockList.getDao()
            if(db.getItems().size == 0) {
                db.insertItem(Item(1, "Long Island Iced Tea", R.drawable.cock2, "1) Add the vodka, rum, tequila, gin, triple sec, simple syrup and lemon juice to a Collins glass filled with ice.\n" +
                        "\n" +
                        "2) Top with a splash of the cola and stir briefly.\n" +
                        "\n" +
                        "3) Garnish with a lemon wedge.\n" +
                        "\n" +
                        "4) Serve with a straw."))
                db.insertItem(Item(2, "Old Fashioned", R.drawable.cock4,"1) Add the sugar and bitters into a mixing glass, then add the water, and stir until the sugar is nearly dissolved.\n" +
                        "\n" +
                        "2) Fill the mixing glass with ice, add the bourbon, and stir until well-chilled.\n" +
                        "\n" +
                        "3) Strain into a rocks glass over one large ice cube.\n" +
                        "\n" +
                        "4) Express the oil of an orange twist over the glass, then drop into the glass to garnish."))
                db.insertItem(Item(3, "Margarita", R.drawable.cock3, "1) Add tequila, orange liqueur, lime juice and agave syrup to a cocktail shaker filled with ice, and shake until well-chilled.\n" +
                        "\n" +
                        "2) Strain into a rocks glass over fresh ice.\n" +
                        "\n" +
                        "3) Garnish with a lime wheel and kosher salt rim (optional)."))
                db.insertItem(Item(4, "Electric fizz", R.drawable.splash, "Add the vodka, rum, tequila, gin, triple sec, simple syrup and lemon juice to a Collins glass filled with ice.\n" +
                        "\n" +
                        "Top with a splash of the cola and stir briefly.\n" +
                        "\n" +
                        "Garnish with a lemon wedge.\n" +
                        "\n" +
                        "Serve with a straw."))
                db.insertItem(Item(5, "Gray Hound", R.drawable.cock1, "Add the vodka, rum, tequila, gin, triple sec, simple syrup and lemon juice to a Collins glass filled with ice.\n" +
                        "\n" +
                        "Top with a splash of the cola and stir briefly.\n" +
                        "\n" +
                        "Garnish with a lemon wedge.\n" +
                        "\n" +
                        "Serve with a straw."))
            }

    }
}