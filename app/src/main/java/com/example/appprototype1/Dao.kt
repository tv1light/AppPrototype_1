package com.example.appprototype1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun instertItem(item: Item)
    @Query("SELECT * FROM Items")
    fun getItems(): Flow<List<Item>>
}