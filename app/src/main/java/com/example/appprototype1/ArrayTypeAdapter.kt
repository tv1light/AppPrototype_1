package com.example.appprototype1

import androidx.room.TypeConverter

class ArrayTypeAdapter {
    @TypeConverter
    fun fromArray(ingredArr: ArrayList<Int>) :String{
        var out : String = ""
        for(i in ingredArr){
            out+=i.toString()
            out+=","
        }
        return out
    }

    @TypeConverter
    fun toArray(data : String) : ArrayList<Int>{
        var out : ArrayList<Int> = arrayListOf()
        var ind : String = ""
        for (i in data){
            if(i == ','){
                out.add(ind.toInt())
                ind=""
            }
            else{
                ind+=i
            }
        }
        return out
    }
}