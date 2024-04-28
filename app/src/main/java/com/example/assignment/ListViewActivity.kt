package com.example.assignment

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.AdapterView
import android.widget.Toast

class ListViewActivity : AppCompatActivity() {
    lateinit var ListViewVar : ListView;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)

        ListViewVar = findViewById(R.id.listDetails)

        var data = resources.getStringArray(R.array.Country)

        var adapter = ArrayAdapter(this@ListViewActivity, android.R.layout.simple_list_item_1, data)
        ListViewVar.adapter = adapter

        ListViewVar.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(applicationContext, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show()
        }
    }
}