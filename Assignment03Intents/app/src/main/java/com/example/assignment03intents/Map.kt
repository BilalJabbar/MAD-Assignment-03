package com.example.assignment03intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Map : AppCompatActivity() {

    lateinit var btn_search_map: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        btn_search_map = findViewById(R.id.btn_findLocation)
        var user_input_location:EditText = findViewById(R.id.et_loc)

        btn_search_map.setOnClickListener({
            var loc = user_input_location.text


            var geo = "geo:0,0?q=${loc}"
            var url = Uri.parse(geo)

            var myInt = Intent(Intent.ACTION_VIEW,url)
            startActivity(myInt)
            Toast.makeText(this,"Searching...",Toast.LENGTH_LONG).show()
        })
    }
}