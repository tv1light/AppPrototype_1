package com.example.appprototype1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ingrid")
data class IngridDataBase (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "Name") //Название
    var name: String,

    @ColumnInfo(name = "Value")// Количество
    var value: Int,

    @ColumnInfo(name = "Image")
    var img: Int
)