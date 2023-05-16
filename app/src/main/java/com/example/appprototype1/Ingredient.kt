package com.example.appprototype1

import android.os.Parcel
import android.os.Parcelable

data class Ingredient (
    val name: String,
    val image: Int,
//    val description: String,
//    val volume: Double,
//    val alternatives: Array<String>,
//    val inFlag: Boolean,
//    val cartFlag: Boolean
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Ingredient> {
        override fun createFromParcel(parcel: Parcel): Ingredient {
            return Ingredient(parcel)
        }

        override fun newArray(size: Int): Array<Ingredient?> {
            return arrayOfNulls(size)
        }
    }
}