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

class week3ciclos : AppCompatActivity() {

    private lateinit var opcion1ciclo: Button
    private lateinit var opcion2ciclo: Button
    private lateinit var opcion3ciclo: Button
    private lateinit var opcion4ciclo: Button
    private lateinit var siguienteciclos: Button
    private lateinit var home3: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week3ciclos)


        opcion1ciclo = findViewById(R.id.opcion1ciclo)
        opcion2ciclo = findViewById(R.id.opcion2ciclo)
        opcion3ciclo = findViewById(R.id.opcion3ciclo)
        opcion4ciclo = findViewById(R.id.opcion4ciclo)
        siguienteciclos = findViewById(R.id.siguienteciclos)
        home3 = findViewById(R.id.home3)

        home3.setOnClickListener { navigateTohome() }

        siguienteciclos.setOnClickListener { navigateTofunciones() }



        opcion1ciclo.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            opcion1ciclo.text = "Incorrecto"
            opcion1ciclo.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed))

        }


        opcion2ciclo.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            opcion2ciclo.text = "Incorrecto"
            opcion2ciclo.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed))

        }

        opcion3ciclo.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            opcion3ciclo.text = "Correcto"
            opcion3ciclo.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed2))
            siguienteciclos.visibility = View.VISIBLE

        }

        opcion4ciclo.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            opcion4ciclo.text = "Incorrecto"
            opcion4ciclo.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed))

        }
    }
    private fun navigateTofunciones() {
        val intent = Intent(this, week4funciones ::class.java)
        startActivity(intent)
    }
    private fun navigateTohome() {
        val intent = Intent(this, IntroProgrammingClassScreen ::class.java)
        startActivity(intent)
    }
}