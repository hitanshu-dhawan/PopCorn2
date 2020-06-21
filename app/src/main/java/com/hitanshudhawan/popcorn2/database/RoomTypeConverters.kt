package com.hitanshudhawan.popcorn2.database

import androidx.room.TypeConverter

class RoomTypeConverters {

    @TypeConverter
    fun fromListOfInt(value: List<Int>): String = value.joinToString(",")

    @TypeConverter
    fun toListOfInt(value: String): List<Int> = value.split(",").map { it.toInt() }

}
