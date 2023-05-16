package com.example.appprototype1

import android.os.Parcel
import android.os.Parcelable

data class Cocktail(
    val name: String?, //Название
    val image: Int, // картинка
//    val cocktailType: String, // Типы, хз сам если что поправишь
//    val createInstructions: String, // Способ приготовления
//    val ingridArr: Map<String,Int>, // Необходимые ингридиенты и количество для 1 коктейля
//    val readyFlag: Boolean,// флаг возможности приготовления
//    val favorFlag: Boolean // флаг заметки
): Parcelable{
//    fun Cocktail_created(){
//        if(readyFlag){
//            for(i in ingridArr){} //берём данные из бд и вычитаем то что в строке 7 //Пока в теории тк бд нет
//        }
//}
//    fun Ready_check(){ // Для флага возможности приготовления
//
//    }
    constructor(parcel: Parcel) : this(
        parcel.readString(),
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

    companion object CREATOR : Parcelable.Creator<Cocktail> {
        override fun createFromParcel(parcel: Parcel): Cocktail {
            return Cocktail(parcel)
        }

        override fun newArray(size: Int): Array<Cocktail?> {
            return arrayOfNulls(size)
        }
    }
}