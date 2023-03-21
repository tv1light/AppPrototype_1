package com.example.appprototype1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Items")
data class Item (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "Coctails")
    var coct: String,
    @ColumnInfo(name = "Ingridients")
    var ingr: String,
        )
