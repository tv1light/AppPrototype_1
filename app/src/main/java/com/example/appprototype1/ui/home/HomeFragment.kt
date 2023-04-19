package com.example.appprototype1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appprototype1.Cocktail
import com.example.appprototype1.R
import com.example.appprototype1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

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
        initializing()
        val layoutManager = GridLayoutManager(context, 2)
        cocktailsRV = view.findViewById(R.id.homeRV)
        cocktailsRV.layoutManager = layoutManager
        cocktailRecipeAdapter = CocktailRecipeAdapter(cocktailsList, context)
        cocktailsRV.adapter = cocktailRecipeAdapter

    }
    private fun initializing(){
        cocktailsList = ArrayList<Cocktail>()
        cocktailsList.add(Cocktail("Long Island Iced Tea", R.drawable.splash))
        cocktailsList.add(Cocktail("Old Fashioned", R.drawable.splash))
        cocktailsList.add(Cocktail("Margarita", R.drawable.margarita))
        cocktailsList.add(Cocktail("Electric fizz", R.drawable.splash))
        cocktailsList.add(Cocktail("Gray Hound", R.drawable.splash))
        cocktailsList.add(Cocktail("Long Island Iced Tea3", R.drawable.splash))
        cocktailsList.add(Cocktail("Long Island Iced Tea3", R.drawable.margarita))
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}