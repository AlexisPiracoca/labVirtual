package com.usta.laboratoriovirtual.classProgramming.introduccion

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.usta.laboratoriovirtual.R

class week1introduction : AppCompatActivity() {

    private lateinit var myButton: Button
    private lateinit var myButton2: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week1introduction)

        myButton = findViewById(R.id.myButton)
        myButton2 = findViewById(R.id.myButton2)

        myButton.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            myButton.text = "Error"
            myButton.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed))

        }


        myButton2.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            myButton2.text = "Correcto"
            myButton2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed2))

        }

    }

}