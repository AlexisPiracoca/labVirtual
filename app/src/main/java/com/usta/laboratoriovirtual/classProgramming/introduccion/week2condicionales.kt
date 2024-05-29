package com.usta.laboratoriovirtual.classProgramming.introduccion

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.usta.laboratoriovirtual.R
import com.usta.laboratoriovirtual.classProgramming.IntroProgrammingClassScreen

class week2condicionales : AppCompatActivity() {

    private lateinit var opcion1condicional: Button
    private lateinit var opcion2condicional: Button
    private lateinit var siguientecondicionales: Button
    private lateinit var home2: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week2condicionales)


        opcion1condicional = findViewById(R.id.opcion1condicional)
        opcion2condicional = findViewById(R.id.opcion2condicional)
        siguientecondicionales = findViewById(R.id.siguientecondicionales)
        home2 = findViewById(R.id.home2)

        home2.setOnClickListener { navigateTohome() }

        siguientecondicionales.setOnClickListener { navigateTociclos() }

        opcion1condicional.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            opcion1condicional.text = "Correcto"
            opcion1condicional.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed2))
            siguientecondicionales.visibility = View.VISIBLE

        }


        opcion2condicional.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            opcion2condicional.text = "Incorrecto"
            opcion2condicional.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed))

        }


        }
    private fun navigateTociclos() {
        val intent = Intent(this, week3ciclos ::class.java)
        startActivity(intent)
    }
    private fun navigateTohome() {
        val intent = Intent(this, IntroProgrammingClassScreen ::class.java)
        startActivity(intent)
    }

}