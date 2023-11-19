package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.AddActivity.AddActivity
import com.example.noteapp.Models.Note_table

import com.example.noteapp.RvAdopter.Rvadopter
import com.example.noteapp.ViewsMoldels.MainActivityViewModel
import com.example.noteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {

        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var mainActivityViewModel: MainActivityViewModel

    var list = ArrayList<Note_table>()
    var tempList = arrayListOf<Note_table>()
    var adopter: Rvadopter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //     DatabaseBuilder.getdatabaseBuilder(this).getNoteDao().insert(Note_table(data = "ikram", colour = 12))

        setSupportActionBar(binding.materialToolbar)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adopter

        binding.searchBtn.setOnClickListener {
            var searchTXT = binding.searchTxt.text.toString()

            if(searchTXT.isNullOrEmpty()){

                adopter?.updateList(list)

            }else{

                list.forEach {

                    if(it.data.contains(searchTXT , ignoreCase = false)){

                        tempList.add(it)
                    }
                }

                list.clear()
                adopter?.updateList(tempList)


            }

        }


        var observer  = Observer<List<Note_table>>{it->

            list.clear()
            list.addAll(it)
            if(adopter==null){
                adopter= Rvadopter(this,list){
                    delete(it)
                }

                binding.recyclerView.layoutManager=LinearLayoutManager(this)
                binding.recyclerView.adapter=adopter

            }else {

                adopter!!.notifyDataSetChanged()

            }
        }

        mainActivityViewModel.noteList.observe(this,observer)



        binding.floatingActionButton.setOnClickListener {

           startActivity(Intent(this@MainActivity,AddActivity::class.java))
        }





    }

    fun delete(position: Int) {
        var notetable: Note_table = list.get(position)
        mainActivityViewModel.delete(notetable)

    }
    /*

     fun delete(position: Int) {
        var notetable: Note_table = list.get(position)
        mainActivityViewModel.delete(notetable)
        list.removeAt(position)
        adopter!!.notifyItemRemoved(position)
    }
     */

}