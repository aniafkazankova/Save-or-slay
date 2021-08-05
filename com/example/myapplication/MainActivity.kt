package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_plastic.*
import java.io.FileInputStream
import java.io.FileOutputStream
import java.lang.String


class MainActivity : AppCompatActivity() {
    val FILE_LEVEL = "file.txt"

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val kol: TextView = findViewById(R.id.kol)

        //saveText_b(kol, 0.1)
        //kol.setText("9.8")
        //saveText(kol)
        //val tef = findViewById<TextView>(R.id.textView5)
        openText_b(kol)
        val krev = findViewById<ImageView>(R.id.krev)
        val fish = findViewById<ImageView>(R.id.fish)
        val delphin = findViewById<ImageView>(R.id.delphin)
        val inter = findViewById<TextView>(R.id.inter)

        //Число с двумя знаками после запятой
        val kit = findViewById<ImageView>(R.id.kit)
        val x = kol.text.toString().toDouble()
        val number:Double = x
        val number3digits:Double = Math.round(number * 1000.0) / 1000.0

        kol.setText(number3digits.toDouble().toString())
        when (number3digits) {
           /* 0.0 ->{
                val inten = Intent(this@MainActivity, com.example.myapplication.start::class.java)
                startActivity(inten)
            }*/
            in 0.0 .. 1.0 -> {
                krev.setImageResource(R.drawable.krev)
            }
            in 1.0 .. 70.0 -> {
                krev.setImageResource(R.drawable.krev)
                fish.setImageResource(R.drawable.fish)
            }
            in 70.0 .. 6_666_664.0 -> {
                krev.setImageResource(R.drawable.krev)
                fish.setImageResource(R.drawable.fish)
                delphin.setImageResource(R.drawable.de)
            }
            else -> {
                krev.setImageResource(R.drawable.krev)
                fish.setImageResource(R.drawable.fish)
                delphin.setImageResource(R.drawable.de)
                kit.setImageResource(R.drawable.kit)

                val inten = Intent(this@MainActivity, com.example.myapplication.end::class.java)
                startActivity(inten)
            }
        }

        val plastik: Button=findViewById(R.id.plastik)
        plastik.setOnClickListener {
            val inten = Intent(this@MainActivity, plastic::class.java)
            startActivity(inten)
        }
        val metall: Button=findViewById(R.id.metall)
        metall.setOnClickListener {
            val inten = Intent(this@MainActivity, com.example.myapplication.metall::class.java)
            startActivity(inten)
        }
        val bouttle: Button=findViewById(R.id.bouttle)
        bouttle.setOnClickListener {
            val int = Intent(this@MainActivity, com.example.myapplication.bouttle::class.java)
            startActivity(int)
        }
        val clothers: Button=findViewById(R.id.clothers)
        clothers.setOnClickListener {
            val intt = Intent(this@MainActivity, com.example.myapplication.clothers::class.java)
            startActivity(intt)
        }
        val paper: Button=findViewById(R.id.paper)
        paper.setOnClickListener {
            val i = Intent(this@MainActivity, com.example.myapplication.paper::class.java)
            startActivity(i)
        }
        /*findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }*/
    }
    fun openText_b(view: View?) {
        var fin: FileInputStream? = null
        fin = openFileInput(FILE_LEVEL)
        val bytes = ByteArray(fin.available())
        fin.read(bytes)
        val text = String(bytes)
        kol.setText(text)

        //val number2digits:Double = Math.round(number3digits * 100.0) / 100.0
        //val solution:Double = Math.round(number2digits * 10.0) / 10.0
        //kol.setText((String.format("%.2f", x) ))
        fin?.close()
    }
    fun saveText(view: View?) {
        var fin: FileInputStream? = null
        fin = openFileInput(FILE_LEVEL)
        val bytes = ByteArray(fin.available())
        fin.read(bytes)
        val t = String(bytes)//данные из файла
        //t2 = t2.toString()//данные из TextView
        fin?.close()
        var fos: FileOutputStream? = null
        fos = openFileOutput(FILE_LEVEL, MODE_PRIVATE)
        //fos.write(((t.toDouble() + t2.toDouble()).toString()).toByteArray())
        fos?.close()
    }
    fun String.toDouble(): Double = java.lang.Double.parseDouble(this.toString())
}