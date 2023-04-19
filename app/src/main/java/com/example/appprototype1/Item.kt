package com.example.appprototype1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Items")
data class Item (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "Name")
    var coct: String,
    @ColumnInfo(name = "Images")
    var img: String,
)