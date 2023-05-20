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


@Suppress("NAME_SHADOWING")
open class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().apply { //Сплэш скрин установка
        }

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//       val it = Item(null,"Bloody Mary", "Vodka") //тестовая херь, думаю будет удобнее её в отдельное окно вынести

        initializeIngredients() //initialize ingredients
        initializeIng2()
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


//        db.clearAllTables()

//lade podklyuchili git, ura
//(huy)
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

    fun initializeIngredients()
    {

        Thread{
            val s = DataBase.getDB(HomeFragment()) // Считывание из бд коктейлей
            val db = s.getDao().getAllIngr()
            for (i in db) {
                ingList.add(Ingredient(i.name, R.drawable.splash))
            }
        }.start()
    }


}

var ingList: ArrayList<Ingredient> = initializeIng2()
fun initializeIng2(): ArrayList<Ingredient>
{
    ingList = ArrayList<Ingredient>()
    ingList.add(Ingredient("Coke", R.drawable.cocke))
    ingList.add(Ingredient("Lemon", R.drawable.lemon))
    ingList.add(Ingredient("Whiskey", R.drawable.whiskey))
    return ingList
}