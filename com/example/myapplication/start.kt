package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.io.FileInputStream
import java.io.FileOutputStream

class start : AppCompatActivity() {
    val FILE_NAME = "name.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val name: TextView = findViewById(R.id.name)
        val surname: TextView = findViewById(R.id.surname)

        val str = surname.getText().toString()+ " " + name.getText().toString()
        val but: Button =findViewById(R.id.button2)
        but.setOnClickListener {
            var fin: FileInputStream? = null
            fin = openFileInput(FILE_NAME)
            val bytes = ByteArray(fin.available())
            fin.read(bytes)
            val t = String(bytes)//данные из файла
            fin?.close()
            var fos: FileOutputStream? = null
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE)
            fos.write(((t.toDouble() + str.toDouble()).toString()).toByteArray())
            fos?.close()

            val i = Intent(this@start, MainActivity::class.java)
            startActivity(i)
        }
    }
}