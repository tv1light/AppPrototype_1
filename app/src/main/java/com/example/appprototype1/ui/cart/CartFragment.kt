package com.example.appprototype1.ui.cart

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appprototype1.*
import com.example.appprototype1.databinding.FragmentCartBinding
import com.example.appprototype1.ui.home.HomeFragment

class CartFragment : Fragment(), CarAdapter.RecyclerViewEvent
{

    private var _binding: FragmentCartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var ingredientsRV: RecyclerView
    lateinit var ingredientsAdapter: CarAdapter
    lateinit var ingList: ArrayList<Ingredient>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val cartViewModel =
            ViewModelProvider(this).get(CartViewModel::class.java)

        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeIngredients()
        val layoutManager = LinearLayoutManager(context)
        ingredientsRV = view.findViewById(R.id.cartRV)
        ingredientsRV.layoutManager = layoutManager
        ingredientsAdapter = CarAdapter(ingList, this)
        ingredientsRV.adapter = ingredientsAdapter
    }
    override fun onItemClick(position: Int) {
        val ingredient = ingList[position]
        val intent = Intent (getActivity(), IngredientScreenActivity::class.java)
        intent.putExtra("ingredient", ingredient)
        startActivity(intent)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun initializeIngredients()
    {
        ingList = ArrayList<Ingredient>()
        Thread{
            val s = DataBase.getDB(HomeFragment()) // Считывание из бд коктейлей
            val db = s.getDao().getAllIngr()
            for (i in db) {
                ingList.add(Ingredient(i.name, R.drawable.splash))
            }
        }.start()
        ingList.add(Ingredient("Lemon", R.drawable.lemon))
        ingList.add(Ingredient("Orange", R.drawable.orange))
        ingList.add(Ingredient("Whiskey", R.drawable.whiskey))
        ingList.add(Ingredient("Jagermeister", R.drawable.jeger))
        ingList.add(Ingredient("Coke", R.drawable.cocke))
        ingList.add(Ingredient("Coke", R.drawable.cocke))
        ingList.add(Ingredient("Coke", R.drawable.cocke))
        ingList.add(Ingredient("Coke", R.drawable.cocke))
        ingList.add(Ingredient("Coke", R.drawable.cocke))
        ingList.add(Ingredient("Coke", R.drawable.cocke))
        ingList.add(Ingredient("Coke", R.drawable.cocke))


    }
}