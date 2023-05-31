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
    private val binding get() = _binding!!
    lateinit var ingList: DataBase
    lateinit var ingredientsRV: RecyclerView
    lateinit var ingredientsAdapter: CarAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val cartViewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        ingredientsRV = view.findViewById(R.id.cartRV)
        ingredientsRV.layoutManager = layoutManager
        ingList = DataBase.getDB(context)
        ingredientsAdapter = CarAdapter(ingList, this)
        ingredientsRV.adapter = ingredientsAdapter
    }
    override fun onItemClick(position: Int) {
        val ingredient = ingList.getDao().getAllIngr().get(position)
        val intent = Intent (getActivity(), IngredientScreenActivity::class.java)
        intent.putExtra("ingredient", ingredient)
        startActivity(intent)
    }

    override fun onItemLongClick(position: Int) {
        //ingredientsRV.adapter?.notifyItemRemoved(position)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}