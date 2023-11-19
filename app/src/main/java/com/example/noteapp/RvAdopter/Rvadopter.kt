package com.example.noteapp.RvAdopter


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.AddActivity.AddActivity
import com.example.noteapp.Models.Note_table
import com.example.noteapp.databinding.RvSampleBinding
import kotlin.random.Random

class Rvadopter(var context: Context, var mlist: List<Note_table>, var delete: (Int) -> Unit) :
    RecyclerView.Adapter<Rvadopter.viewHoler>() {


    inner class viewHoler(val binding: RvSampleBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHoler {

        val binding = RvSampleBinding.inflate(LayoutInflater.from(context), parent, false)

        return viewHoler(binding)
    }

    override fun getItemCount(): Int {
        return mlist.size
    }


    fun updateList(list_coming_from_mainactivity : ArrayList<Note_table>){
        mlist=list_coming_from_mainactivity
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: viewHoler, @SuppressLint("RecyclerView") position: Int) {


        holder.binding.data.text = mlist.get(position).data
        holder.binding.rollno.text = mlist.get(position).colour.toString()
        holder.binding.dateee.text = mlist.get(position).date.toString()


        holder.binding.cardview.setCardBackgroundColor(when(mlist.get(position).colour){

            1->{ Color.CYAN}
            2->{ Color.RED}
            3->{ Color.GREEN}
            4->{ Color.MAGENTA}
            5->{ Color.YELLOW}
            6->{ Color.BLUE}
            else -> {Color.BLACK}
        })

 // click to update data

        holder.itemView.setOnClickListener {

            var intent  = Intent(context,AddActivity::class.java)
            intent.putExtra("note", mlist.get(position))
            context.startActivity(intent)
        }


holder.itemView.setOnLongClickListener(object :OnLongClickListener{
    override fun onLongClick(v: View?): Boolean {
        Toast.makeText(context, " Note has been deleted !!!", Toast.LENGTH_SHORT).show()
        delete(position)
        return true
    }

})


    }
}

