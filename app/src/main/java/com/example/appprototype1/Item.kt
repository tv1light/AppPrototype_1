package com.example.appprototype1

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Items")
data class Item (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "Name")
    val name: String = "test", //Название

    @ColumnInfo(name = "Image")
    val image: Int = 0, // картинка

//    @ColumnInfo(name = "Cocktail Type")
//    val cocktailType: String = "test", // Типы, хз сам если что поправишь

    @ColumnInfo(name = "Create Instructions")
    val createInstructions: String = "test", // Способ приготовления

    @ColumnInfo(name = "Ingredients Array")
    val ingredArr: ArrayList<Int> = arrayListOf(), // Необходимые ингридиенты и количество для 1 коктейля

//    @ColumnInfo(name = "Volume Ingredients")
//    val volArr: ArrayList<String> = arrayListOf(""),

    @ColumnInfo(name = "Ready Flag")
    val readyFlag: Boolean = false,// флаг возможности приготовления

    @ColumnInfo(name = "Favor Flag")
    val favorFlag: Boolean = false
)