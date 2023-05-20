package com.example.appprototype1

import androidx.room.TypeConverter

class ArrayTypeAdapter {
    @TypeConverter
    fun fromArray(ingredArr: ArrayList<String>) :String{
        var out : String = ""
        for(i in ingredArr){
            out+=i
            out+=","
        }
        return out
    }

    @TypeConverter
    fun toArray(data : String) : ArrayList<String>{
        var out : ArrayList<String> = arrayListOf()
        var ind : String = ""
        for (i in data){
            if(i == ','){
                out.add(ind)
                ind=""
            }
            else{
                ind+=i
            }
        }
        return out
    }
}