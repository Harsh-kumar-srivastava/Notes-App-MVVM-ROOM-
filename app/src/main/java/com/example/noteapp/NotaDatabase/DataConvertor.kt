package com.example.noteapp.NotaDatabase

import androidx.room.TypeConverter
import java.util.Date

class DataConvertor {

    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        return dateLong?.let { Date(it) }
    }

    @TypeConverter
    fun fromDate(date: Date?): Long {
        return date!!.getTime()
    }
}