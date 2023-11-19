package com.example.noteapp.ViewsMoldels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.Models.Note_table

import com.example.noteapp.Repository.Repo
import kotlinx.coroutines.launch

class AddActivityViewMode(application: Application) : AndroidViewModel(application) {

    var repo : Repo

    init {
        repo=Repo(application)

    }

    fun insert( noteTable: Note_table  ,  Success : () ->Unit){
      viewModelScope.launch {

          repo.insert(noteTable)
          Success()

      }
    }


    fun update( noteTable: Note_table  ,  Success : () ->Unit){
       viewModelScope.launch {
           repo.update(noteTable)
           Success()

       }
    }
}