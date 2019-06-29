package com.example.todolist

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.provider.Settings.Global.putString
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var arraylist=ArrayList<String>()
        var id=""

        arraylist=FileHelper.readData(this)//reading data on a file

        button.setOnClickListener {
            var item =et1.text.toString()
            arraylist.add(item)
            item=""

            //WRITING DATA ON id]
            FileHelper.writeData(arraylist,this)// writing data on a file

            Toast.makeText(this,"TASK ADDED",Toast.LENGTH_SHORT).show()
        }






        val myadapter=ArrayAdapter<String>(this,R.layout.list_view,R.id.tv,arraylist)
        lv.adapter=myadapter

        lv.setOnItemClickListener{ parent, view, position, id ->
            arraylist.removeAt(position)
            myadapter.notifyDataSetChanged()
            FileHelper.writeData(arraylist,this)// writing data on a file
            Toast.makeText(this,"Deleted",Toast.LENGTH_SHORT).show()
        }

    }



}
