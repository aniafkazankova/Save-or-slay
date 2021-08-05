package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.io.FileInputStream
import java.io.FileOutputStream
import java.sql.DriverManager

class paper : AppCompatActivity() {
    val FILE_LEVEL = "file.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paper)

        val interesting: TextView = findViewById(R.id.interesting)
        val textView7: TextView = findViewById(R.id.textView7)
        val bt: Button = findViewById(R.id.button)
        val can: Button=findViewById(R.id.can)
        can.setOnClickListener {
            val inten = Intent(this@paper, MainActivity::class.java)
            startActivity(inten)
        }

        val languages = resources.getStringArray(R.array.pap)
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
                        "Бумага, тетради" -> {
                            interesting.setText("Оу, из этого можно сделать:" +
                                    " изделия из полиграфии, писчую бумагу, туалетную бумагу, салфелки и бумажные полотенца")
                        }
                        "Газеты" -> {
                            interesting.setText("А из этого можно сделать картон для коробок и контейнеров")
                        }
                        "Книги"-> {
                            interesting.setText("Хм, из этой вещи мы можем сделать одноразовую посуду, газеты")
                        }
                        "Документы и архивы"-> {
                            interesting.setText("Хм, из этого мы можем сделать кравт-бумагу, тепло и звуко-изоляцинные материалы")
                        }
                        "Картон, гофрокартон"-> {
                            interesting.setText("Удивительно, но из этой вещи мы можем сделать строительные материалы, топливные пеллеты и брикеты")
                        }
                        else -> {
                            DriverManager.println("exception")
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
                            an = (0.31).toDouble()
                        }
                        "2" -> {
                            an = (0.62).toDouble()
                        }
                        "3" -> {
                            an = (1.93).toDouble()
                        }
                        "4" -> {
                            an = (1.24).toDouble()                       }
                        "5" -> {
                            an = (1.55).toDouble()                 }

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
                this@paper,
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