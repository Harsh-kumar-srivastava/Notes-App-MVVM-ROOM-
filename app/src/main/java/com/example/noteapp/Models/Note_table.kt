package com.example.noteapp.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.Date


@Entity(tableName = "notw_table")
class Note_table(
    @PrimaryKey(autoGenerate = true)  val key: Int=0,
    @ColumnInfo(name="data") var data : String,
    @ColumnInfo(name="color_code") val colour : Int,
    @ColumnInfo(name = "Date") var date :Date
) : Serializable {

}
