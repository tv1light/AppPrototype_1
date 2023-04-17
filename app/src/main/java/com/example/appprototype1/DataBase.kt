package com.example.appprototype1

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appprototype1.ui.favorites.FavoritesFragment

@Database(entities = [Item::class], version = 1)
abstract class DataBase : RoomDatabase(){
    abstract fun getDao(): Dao
    companion object{
        fun getDB(context: FavoritesFragment): DataBase{
            return Room.databaseBuilder(
                context.requireContext(),
                DataBase::class.java,
                "DataBase.db"
            ).build()
        }
    }
}

