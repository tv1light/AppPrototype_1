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
    var id: Int? = null,

    @ColumnInfo(name = "Name") //Название
    var name: String = "test",

    @ColumnInfo(name = "Image")// Картинка
    var image: Int = 0,

    @ColumnInfo(name = "Value")// Количество
    var value: Int = 0,

    @ColumnInfo(name = "inBar")// Наличие
    var inBar: Boolean

) : Parcelable {

    fun isSelected(): Boolean{
        return inBar
    }

    fun select(){
        inBar = true;

    }

    fun nSelect()
    {
        inBar = false
    }
    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readBoolean()
    )

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeInt(image)
        parcel.writeInt(value)
    }

    companion object CREATOR : Parcelable.Creator<IngridDataBase> {
        override fun createFromParcel(parcel: Parcel): IngridDataBase {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                IngridDataBase(parcel)
            } else {
                TODO("VERSION.SDK_INT < Q")
            }
        }

        override fun newArray(size: Int): Array<IngridDataBase?> {
            return arrayOfNulls(size)
        }
    }
}