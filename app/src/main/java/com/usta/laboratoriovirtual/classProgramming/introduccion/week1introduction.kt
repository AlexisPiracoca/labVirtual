package com.usta.laboratoriovirtual.classProgramming.introduccion

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.usta.laboratoriovirtual.R
import com.usta.laboratoriovirtual.classProgramming.IntroProgrammingClassScreen

class week1introduction : AppCompatActivity() {

    private lateinit var myButton: Button
    private lateinit var myButton2: Button
    private lateinit var siguienteintroduccion: Button
    private lateinit var home1: ImageButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week1introduction)

        myButton = findViewById(R.id.myButton)
        myButton2 = findViewById(R.id.myButton2)
        siguienteintroduccion = findViewById(R.id.siguienteintroduccion)
        home1 = findViewById(R.id.home1)

        home1.setOnClickListener { navigateTohome() }

        siguienteintroduccion.setOnClickListener { navigateTocondicionales() }
        myButton.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            myButton.text = "Error"
            myButton.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed))

        }


        myButton2.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            myButton2.text = "Correcto"
            myButton2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed2))
            siguienteintroduccion.visibility = View.VISIBLE

        }

    }

    private fun navigateTocondicionales() {
        val intent = Intent(this, week2condicionales ::class.java)
        startActivity(intent)
    }

    private fun navigateTohome() {
        val intent = Intent(this, IntroProgrammingClassScreen ::class.java)
        startActivity(intent)
    }

}