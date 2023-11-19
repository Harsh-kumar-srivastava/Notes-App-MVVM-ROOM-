package com.example.noteapp.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.noteapp.Models.Note_table
import com.example.noteapp.NDao.NotaDao
import com.example.noteapp.NotaDatabase.DatabaseBuilder

class Repo( context: Context) {

    var objdao : NotaDao = DatabaseBuilder.getdatabaseBuilder(context).getNoteDao()

   suspend fun insert(notetable : Note_table){

        objdao.insert(notetable)
    }

    fun ReadAll() : LiveData<List<Note_table>>{

        return objdao.readNotes()
    }
//    fun ReadAll() :List<Note_table>{
//
//        return objdao.readNotes()
//    }

    suspend fun delete(notetable: Note_table){

        objdao.delete(notetable)
    }

    suspend fun update(notetable: Note_table){

        objdao.update(notetable)
    }




}