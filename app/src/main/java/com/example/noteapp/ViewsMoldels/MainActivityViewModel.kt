package com.example.noteapp.ViewsMoldels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.noteapp.Models.Note_table
import com.example.noteapp.Repository.Repo
import kotlinx.coroutines.launch

class MainActivityViewModel (applicaton : Application) : AndroidViewModel(applicaton){

    var noteList : LiveData<List<Note_table>>
//    lateinit var noteList : List<Note_table>
     var repo: Repo

    init {
        repo=Repo(applicaton)
        noteList=repo.ReadAll()
    }

    fun delete(notetable : Note_table){

        viewModelScope.launch {
            repo.delete(notetable)
        }

    }
}