package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.android.synthetic.main.activity_main2.*
import java.io.FileInputStream
import java.lang.String

class end : AppCompatActivity() {
    val FILE_NAME = "name.txt"
    @SuppressLint("RestrictedApi")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        val but = findViewById<Button>(R.id.button3)
        val textView8 = findViewById<TextView>(R.id.textView8)
        var fin: FileInputStream? = null
        fin = openFileInput(FILE_NAME)
        val bytes = ByteArray(fin.available())
        fin.read(bytes)
        val text = String(bytes)
        textView8.setText(text)
        fin?.close()

        but.setOnClickListener {
            val drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.drawing, null);

            val bitmap = (drawable as BitmapDrawable?)!!.bitmap
            val savedImageURL = MediaStore.Images.Media.insertImage(
                contentResolver,
                bitmap,
                "Диплом",
                "Диплом самого лучшего защитника животных"
            )
            val savedImageURI: Uri = Uri.parse(savedImageURL)
        }
    }
}