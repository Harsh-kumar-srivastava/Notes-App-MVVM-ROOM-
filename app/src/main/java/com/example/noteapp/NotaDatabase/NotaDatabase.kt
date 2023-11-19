package com.example.noteapp.NotaDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.noteapp.Models.Note_table
import com.example.noteapp.NDao.NotaDao

@TypeConverters(DataConvertor::class)
@Database(entities = arrayOf(Note_table::class), exportSchema = false, version = 3)

abstract class NotaDatabase : RoomDatabase() {

    abstract fun getNoteDao() : NotaDao



}