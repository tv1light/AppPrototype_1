package com.example.appprototype1.ui.favorites


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appprototype1.DataBase
import com.example.appprototype1.IngridDataBase
import com.example.appprototype1.Item
import com.example.appprototype1.databinding.FragmentFavoritesBinding
import com.example.appprototype1.ui.home.HomeFragment

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val favoritesViewModel =
            ViewModelProvider(this).get(FavoritesViewModel::class.java)

        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val db = DataBase.getDB(HomeFragment())

        binding.buttonSave.setOnClickListener{
            val it = Item(null, binding.edCoct.text.toString(), "0")
            Thread{ // Открытие потока для разделения
                db.getDao().insertItem(it)
            }.start()
            val ing = IngridDataBase(null,binding.edIngr.text.toString(),100, 0)
            Thread{
                db.getDao().insertIngr(ing)
            }.start()
        }

        binding.buttonNuke.setOnClickListener{
            Thread{
                db.getDao().nukeTable()
            }.start()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}