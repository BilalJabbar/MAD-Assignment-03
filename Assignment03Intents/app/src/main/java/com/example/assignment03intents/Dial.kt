package com.example.assignment03intents

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat


class Dial : AppCompatActivity() {
    lateinit var btn:Button
    lateinit var txt:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dial)

btn=findViewById<Button>(R.id.button)
        txt=findViewById(R.id.editTextPhone)

        btn.setOnClickListener{
            if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this,"Please Grant Permission",Toast.LENGTH_LONG).show()
                requestPermissions()
            }
            else {
             //   val it = Intent(Intent.ACTION_DIAL)
                val it = Intent(Intent.ACTION_CALL)
                var number = txt.text
                it.data = Uri.parse("tel:$number")
                startActivity(it)
            }
        }
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(this, arrayOf<String>(android.Manifest.permission.CALL_PHONE),1)
    }

    }
}