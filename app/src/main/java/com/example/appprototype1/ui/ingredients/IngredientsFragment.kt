package com.example.appprototype1.ui.ingredients

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
import com.example.appprototype1.databinding.FragmentIngredientsBinding

class IngredientsFragment : Fragment(), IngredientsAdapter.RecyclerViewEvent {

    private var _binding: FragmentIngredientsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var ingredientsRV: RecyclerView
    lateinit var ingredientsAdapter: IngredientsAdapter
    lateinit var ingList: DataBase
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
        ingList = DataBase.getDB(context)
        val layoutManager = LinearLayoutManager(context)
        ingredientsRV = view.findViewById(R.id.ingredientsRV)
        ingredientsRV.layoutManager = layoutManager
        ingredientsAdapter = IngredientsAdapter(ingList, this)
        ingredientsRV.adapter = ingredientsAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {
            val intent = Intent(activity, IngredientScreenActivity::class.java)
            intent.putExtra("ingredient", position)
            startActivity(intent)
    }
}