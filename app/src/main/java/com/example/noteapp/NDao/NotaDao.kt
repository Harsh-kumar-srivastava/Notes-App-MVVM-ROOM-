package com.example.noteapp.NDao

import androidx.core.location.LocationRequestCompat.Quality
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.noteapp.Models.Note_table

@Dao
interface NotaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(noteTable: Note_table)

    @Update
    suspend fun update(noteTable: Note_table)

    @Delete
    suspend fun delete(noteTable: Note_table)

    @Query("SELECT * FROM notw_table ORDER BY Date DESC")
    fun readNotes(): LiveData<List<Note_table>>

//    @Query("SELECT * FROM notw_table")
//    fun readNotes() : List<Note_table>
//    @Delete
//    fun deletaAll()
}


