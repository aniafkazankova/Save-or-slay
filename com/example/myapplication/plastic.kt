package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_plastic.*
import java.io.*
import java.lang.Integer.parseInt
import java.sql.DriverManager.println


class plastic : AppCompatActivity() {

    val FILE_LEVEL = "file.txt"
    fun main(args: Array<String>) {
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plastic)

        val interesting: TextView = findViewById(R.id.interesting)
        val textView7: TextView = findViewById(R.id.textView7)
        val bt: Button = findViewById(R.id.button)
      //  System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + t)
//        val content=File("file_path").readText()
//        textView7.setText(content)


/*
        val sps = getSharedPreferences("share", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sps.edit()
        val name = sps.getString("name", "")
        var age = sps.getInt("age", 0)
        age = age+10
        interesting.setText(age.toString())
        System.out.println("======================================================================"+ age)
        editor.putInt("age", age)
        val married = sps.getBoolean("married", false)
        val can: Button=findViewById(R.id.can)
        can.setOnClickListener {
            val inten = Intent(this@, MainActivity::class.java)
            startActivity(inten)
        }
*/
        val can: Button=findViewById(R.id.can)
        can.setOnClickListener {
            val inten = Intent(this@plastic, MainActivity::class.java)
            startActivity(inten)
        }
        val languages = resources.getStringArray(R.array.plas)
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
                        "Бутылки" -> {
                            interesting.setText(
                                "Оу, из этого можно сделать:" +
                                        " сумки-шопперы, полиэфирное волокно, преформы для бутылок, геотекстиль и изоляцию для проводов"
                            )
                        }
                        "Мусорные пакеты, пищевая плёнка" -> {
                            interesting.setText(
                                "Ау этого предмета большое будующее. Мы сделаем из этого: корзины для компоста, напольную плитку, вкладыши для мусорных контейнеров," +
                                        " панели, лежачих полицейских и пузырчатую плёнку"
                            )
                        }
                        "Нейлоновые ткани" -> {
                            interesting.setText("Хм, из этой вещи мы можем сделать дорожные знаки или пластмассовые пиломатериалы")
                        }
                        "Одноразовая посуда" -> {
                            interesting.setText("Хм, из этого мы можем сделать пенополистерольные панели, пенопластовую упаковку, изоляцию и упаковку для яиц")
                        }
                        "Детские бутылочки и бутылки для кулера" -> {
                            interesting.setText("Удивительно, но из этой вещи мы можем сделать дорожные знаки или пластмассовые пиломатериалы")
                        }
                        else -> {
                            println("___________________________________exception______________________")
                        }
                    }
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        }
        //var p : Double = kol.text.toString().toDouble()
        //System.out.println("jkljnlkjnvk jhcnvi jnfckvjnxjfhnvjhdnjvhljhdfncjvhnjdhfnvujshfdnvjnesjfhdvnojdfhvoisjdfhbnovjshdfnvojhcvvjkdfnboshdf;lcvhoseldjhkv"+ p)
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
                            an = (0.43).toDouble()
                        }
                        "2" -> {
                            an = (0.86).toDouble()
                        }
                        "3" -> {
                            an = (1.29).toDouble()
                        }
                        "4" -> {
                            an = (1.72).toDouble()
                        }
                        "5" -> {
                            an = (2.15).toDouble()
                        }

                        else -> { // Note the block
                            println("___________________________________exception______________________")
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
                this@plastic,
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