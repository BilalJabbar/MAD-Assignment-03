package com.example.assignment03intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btn_map:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_map = findViewById(R.id.btn_map)

        btn_map.setOnClickListener({
            startActivity(Intent(this, Map::class.java))
        })
    }
}