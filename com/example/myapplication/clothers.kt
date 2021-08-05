package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.io.FileInputStream
import java.io.FileOutputStream
import java.sql.DriverManager

class clothers : AppCompatActivity() {
    val FILE_LEVEL = "file.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clothers)

        val interesting: TextView = findViewById(R.id.interesting)
        val textView7: TextView = findViewById(R.id.textView7)
        val bt: Button = findViewById(R.id.button)
        val can: Button=findViewById(R.id.can)
        can.setOnClickListener {
            val inten = Intent(this@clothers, MainActivity::class.java)
            startActivity(inten)
        }

        val languages = resources.getStringArray(R.array.clo)
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, languages
            )
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    when (languages[position]) {
                        "Одежда" -> {
                            interesting.setText("Оу, из этого можно сделать:" +
                                    " Обтирочную ветошь")
                        }
                        "Обивка мебели" -> {
                            interesting.setText("Хм, из этой вещи мы можем сделать одежду для животных")
                        }
                        "Домашний текстиль"-> {
                            interesting.setText("Ау этого предмета большое будующее. Мы сделаем из этого: полиэстер и нейлон, а потом из него сшить новую одежду" +
                                    ", а потом ещё нейлон, одежду, нейлон..."
                                )
                        }
                        "Отходы производства, полученные при изготовлении тканей и вещей"-> {
                            interesting.setText("Хм, из этого мы можем сделать новую ткань")
                        }
                        "Кухонные ткани"-> {
                            interesting.setText("Удивительно, но из этой вещи мы можем сделать пряжу и нитки")
                        }
                        else -> {
                            DriverManager.println("___________________________________exception______________________")
                        }
                    }
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        }
        var an = 0.0
        val kl = resources.getStringArray(R.array.number)
        val spin = findViewById<Spinner>(R.id.spinner2)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, kl
            )
            spin.adapter = adapter
            spin.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    //val str = textView7.getText()
                    when (kl[position]) {
                        "1" -> {
                            an = (0.57).toDouble()
                        }
                        "2" -> {
                            an = (1.14).toDouble()
                        }
                        "3" -> {
                            an = (1.71).toDouble()
                        }
                        "4" -> {
                            an = (2.58).toDouble()                       }
                        "5" -> {
                            an = (3.15).toDouble()                 }

                        else -> { // Note the block
                            DriverManager.println("___________________________________exception______________________")
                        }
                    }
                }
                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }
        }
        bt.setOnClickListener {
            saveText_b(textView7, an)
            Toast.makeText(
                this@clothers,
                "+ " + an.toString(), Toast.LENGTH_SHORT
            ).show()
        }
    }
    fun saveText_b(view: View?, text:Double) {

        var fin: FileInputStream? = null
        fin = openFileInput(FILE_LEVEL)
        val bytes = ByteArray(fin.available())
        fin.read(bytes)
        val t = String(bytes)//данные из файла
        // t2 = text.toString()//данные из TextView
        fin?.close()
        var fos: FileOutputStream? = null
        fos = openFileOutput(FILE_LEVEL, MODE_PRIVATE)
        fos.write(((t.toDouble() + text.toDouble()).toString()).toByteArray())
        fos?.close()
    }
    fun java.lang.String.toDouble(): Double = java.lang.Double.parseDouble(this.toString())

}