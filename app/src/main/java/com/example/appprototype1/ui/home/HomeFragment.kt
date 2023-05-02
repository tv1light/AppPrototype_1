package com.example.appprototype1.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appprototype1.*
import com.example.appprototype1.databinding.FragmentHomeBinding



class HomeFragment : Fragment(), CocktailRecipeAdapter.RecyclerViewEvent {

    private var _binding: FragmentHomeBinding? = null


    private val binding get() = _binding!!

    lateinit var cocktailsRV: RecyclerView
    lateinit var cocktailRecipeAdapter: CocktailRecipeAdapter
    lateinit var cocktailsList: ArrayList<Cocktail>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = DataBase.getDB(this) // Считывание из бд коктейлей

        initializing(s)
        val layoutManager = GridLayoutManager(context, 2)
        cocktailsRV = view.findViewById(R.id.homeRV)
        cocktailsRV.layoutManager = layoutManager
        cocktailRecipeAdapter = CocktailRecipeAdapter(cocktailsList, this)
        cocktailsRV.adapter = cocktailRecipeAdapter
//        if(binding.edSearch.text.toString()!= ""){
//            searcher(binding.edSearch.text.toString(),s)
//        }
    }
    private fun initializing(s : DataBase){
        cocktailsList = ArrayList<Cocktail>()
        Thread{
            val db = s.getDao().getItems()
            for (i in db) {
                cocktailsList.add(Cocktail(i.coct, R.drawable.splash))
            }
        }.start()
        cocktailsList.add(Cocktail("Add Cocktail", R.drawable.plus))
        cocktailsList.add(Cocktail("Long Island Iced Tea", R.drawable.cock2))
        cocktailsList.add(Cocktail("Old Fashioned", R.drawable.cock4))
        cocktailsList.add(Cocktail("Margarita", R.drawable.cock3))
        cocktailsList.add(Cocktail("Electric fizz", R.drawable.splash))
        cocktailsList.add(Cocktail("Gray Hound", R.drawable.cock1))
        cocktailsList.add(Cocktail("Long Island Iced Tea", R.drawable.cock2))
        cocktailsList.add(Cocktail("Old Fashioned", R.drawable.cock4))
        cocktailsList.add(Cocktail("Margarita", R.drawable.cock3))
        cocktailsList.add(Cocktail("Electric fizz", R.drawable.splash))
        cocktailsList.add(Cocktail("Gray Hound", R.drawable.cock1))
    }

    private fun searcher(search: String, s : DataBase){
        cocktailsList = ArrayList<Cocktail>()
        val db = s.getDao().getItems()
        for (i in db) {
            if (search in i.coct) {
                cocktailsList.add(Cocktail(i.coct, R.drawable.splash))
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {
        if(position == 0)
        {
            val intent = Intent(getActivity(), AddCocktailActivity::class.java)
            startActivity(intent)
        }
        else {
            val cocktail = cocktailsList[position]
            val intent = Intent(getActivity(), CocktailScreenActivity::class.java)
            startActivity(intent)
        }
    }
}