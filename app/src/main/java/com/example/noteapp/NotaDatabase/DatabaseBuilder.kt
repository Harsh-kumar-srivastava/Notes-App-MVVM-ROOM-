package com.example.noteapp.NotaDatabase

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

object DatabaseBuilder {

    private var INSTANCE: NotaDatabase? = null


    @OptIn(InternalCoroutinesApi::class)
    fun getdatabaseBuilder(context: Context): NotaDatabase {


        if (INSTANCE == null) {

            synchronized(NotaDatabase::class) {

                INSTANCE = Room.databaseBuilder(context, NotaDatabase::class.java, "note_table.db")
                    .setJournalMode(RoomDatabase.JournalMode.TRUNCATE).fallbackToDestructiveMigration().build()
            }
        }



        return INSTANCE!!
    }
}