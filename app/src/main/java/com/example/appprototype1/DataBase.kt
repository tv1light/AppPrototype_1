package com.example.appprototype1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.appprototype1.ui.favorites.FavoritesFragment
import com.example.appprototype1.ui.home.HomeFragment

@Database(entities = [Item::class,IngridDataBase::class], version = 5, exportSchema = false)
@TypeConverters(ArrayTypeAdapter::class)
abstract class DataBase : RoomDatabase(){

    abstract fun getDao(): Dao

    companion object{

        lateinit var db: DataBase
        fun inDB(context: Context): DataBase{
            if (this::db.isInitialized){
                return db
            }
            db = Room.databaseBuilder(
                context,
                DataBase::class.java,
                "DataBase.db"
            ).build()
            return db
        }

        fun getDB(context: HomeFragment):DataBase{
            if (this::db.isInitialized){
                return db
            }
            db = Room.databaseBuilder(
                context.requireContext(),
                DataBase::class.java,
                "DataBase.db"
            ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
            return db
        }
    }
}