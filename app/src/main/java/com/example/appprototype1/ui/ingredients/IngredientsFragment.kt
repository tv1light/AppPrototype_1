package com.example.appprototype1.ui.ingredients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appprototype1.R
import com.example.appprototype1.databinding.FragmentIngredientsBinding
import com.example.appprototype1.Ingredient

class IngredientsFragment : Fragment() {

    private var _binding: FragmentIngredientsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var ingredientsRV: RecyclerView
    lateinit var ingredientsAdapter: IngredientsAdapter
    lateinit var ingList: ArrayList<Ingredient>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val ingredientsViewModel =
            ViewModelProvider(this).get(IngredientsViewModel::class.java)
        _binding = FragmentIngredientsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeIngredients()
        val layoutManager = LinearLayoutManager(context)
        ingredientsRV = view.findViewById(R.id.ingredientsRV)
        ingredientsRV.layoutManager = layoutManager
        ingredientsAdapter = IngredientsAdapter(ingList, context)
        ingredientsRV.adapter = ingredientsAdapter
    }

    private fun initializeIngredients()
    {
        ingList.add(Ingredient("Lemon", R.drawable.splash))

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}