package com.example.noteapp.AddActivity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem


import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.Models.Note_table
import com.example.noteapp.R
import com.example.noteapp.ViewsMoldels.AddActivityViewMode
import com.example.noteapp.databinding.ActivityAddBinding
import java.util.Date
import kotlin.random.Random

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding
    lateinit var note_table: Note_table
    private lateinit var addActivityViewMode: AddActivityViewMode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addActivityViewMode = ViewModelProvider(this).get(AddActivityViewMode::class.java)
        setSupportActionBar(findViewById(R.id.toolbar))


        if (intent.hasExtra("note")) {

            note_table = intent.getSerializableExtra("note") as Note_table
            binding.content.etEditText?.setText(note_table.data)

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_add, menu)
         menuInflater.inflate(R.menu.left_menue,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {


            R.id.save -> {

                if(intent.hasExtra("note")){
                    note_table.data = binding.content.etEditText?.text.toString()
                    note_table.date= Date()
                    addActivityViewMode.update(note_table) {
                        finish()
                    }

                }else{
                    note_table = Note_table(
                        data = binding.content.etEditText?.text.toString(),
                        colour = Random.nextInt(5) + 1,
                        date = Date()
                    )
                    addActivityViewMode.insert(note_table) {
                        finish()
                    }
                }


            }

            // second option menu code


        }

        return true
    }
}