package com.example.appprototype1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertItem(item: Item)
    @Query("SELECT * FROM Items")
    fun getItems(): List<Item>
    @Query("DELETE FROM Items")
    fun nukeTable()
    @Insert
    fun insertIngr(item: IngridDataBase)
    @Query("SELECT * FROM Ingrid")
    fun getAllIngr(): List<IngridDataBase>
    @Query("DELETE FROM Ingrid")
    fun nukeIngridTable()
}