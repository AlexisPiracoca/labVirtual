package com.usta.laboratoriovirtual.classProgramming.introduccion

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.usta.laboratoriovirtual.R

class week4funciones : AppCompatActivity() {

    private lateinit var opcion1funcion: Button
    private lateinit var opcion2funcion: Button
    private lateinit var opcion3funcion: Button
    private lateinit var opcion4funcion: Button
    private lateinit var siguientearreglos: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week4funciones)

        opcion1funcion = findViewById(R.id.opcion1funcion)
        opcion2funcion = findViewById(R.id.opcion2funcion)
        opcion3funcion = findViewById(R.id.opcion3funcion)
        opcion4funcion = findViewById(R.id.opcion4funcion)
        siguientearreglos = findViewById(R.id.siguientearreglos)

        siguientearreglos.setOnClickListener { navigateToarreglos() }



        opcion1funcion.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            opcion1funcion.text = "Incorrecto"
            opcion1funcion.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed))

        }


        opcion2funcion.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            opcion2funcion.text = "Incorrecto"
            opcion2funcion.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed))
    }

        opcion3funcion.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            opcion3funcion.text = "Correcto"
            opcion3funcion.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed2))
            siguientearreglos.visibility = View.VISIBLE

        }

        opcion4funcion.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            opcion4funcion.text = "Incorrecto"
            opcion4funcion.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed))

        }
    }

    private fun navigateToarreglos() {
        val intent = Intent(this, week5arreglos ::class.java)
        startActivity(intent)
    }
}