package com.example.appprototype1

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ingrid")
data class IngridDataBase (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = DataBase.db.getDao().getAllIngr().size - 1,

    @ColumnInfo(name = "Name") //Название
    var name: String = "test",

    @ColumnInfo(name = "Image")// Картинка
    var image: Int = 0,

    @ColumnInfo(name = "Value")// Количество
    var value: Int = 0,

    @ColumnInfo(name = "inBar")// Наличие
    var inBar: Boolean = false
)