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

    @ColumnInfo(name = "Cocktail Type")
    val cocktailType: String = "test", // Типы, хз сам если что поправишь

    @ColumnInfo(name = "Create Instructions")
    val createInstructions: String = "test", // Способ приготовления

//    @ColumnInfo(name = "Ingredients Array")
//    val ingredArr: ArrayList<String> = arrayListOf(""), // Необходимые ингридиенты и количество для 1 коктейля
//
//    @ColumnInfo(name = "Volume Ingredients")
//    val volArr: ArrayList<String> = arrayListOf(""),

    @ColumnInfo(name = "Ready Flag")
    val readyFlag: Boolean = false,// флаг возможности приготовления

    @ColumnInfo(name = "Favor Flag")
    val favorFlag: Boolean = false
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
//        TODO("ingredArr"),
//        TODO("volArr"),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeInt(image)
        parcel.writeString(cocktailType)
        parcel.writeString(createInstructions)
        parcel.writeByte(if (readyFlag) 1 else 0)
        parcel.writeByte(if (favorFlag) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}