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

class week5arreglos : AppCompatActivity() {


    private lateinit var opcion1arreglo: Button
    private lateinit var opcion2arreglo: Button
    private lateinit var opcion3arreglo: Button
    private lateinit var opcion4arreglo: Button
    private lateinit var siguientearreglos: Button
    private lateinit var home5: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week5arreglos)

        opcion1arreglo = findViewById(R.id.opcion1arreglo)
        opcion2arreglo = findViewById(R.id.opcion2arreglo)
        opcion3arreglo = findViewById(R.id.opcion3arreglo)
        opcion4arreglo = findViewById(R.id.opcion4arreglo)
        siguientearreglos = findViewById(R.id.siguientehome)
        home5 = findViewById(R.id.home5)

        home5.setOnClickListener { navigateTohome() }

        siguientearreglos.setOnClickListener { navigateToMenu() }



        opcion1arreglo.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            opcion1arreglo.text = "Incorrecto"
            opcion1arreglo.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed))

        }


        opcion2arreglo.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            opcion2arreglo.text = "Incorrecto"
            opcion2arreglo.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed))
        }

        opcion3arreglo.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            opcion3arreglo.text = "Correcto"
            opcion3arreglo.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed2))
            siguientearreglos.visibility = View.VISIBLE

        }

        opcion4arreglo.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            opcion4arreglo.text = "Incorrecto"
            opcion4arreglo.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed))

        }
    }

    private fun navigateToMenu() {
        val intent = Intent(this, IntroProgrammingClassScreen ::class.java)
        startActivity(intent)
    }
    private fun navigateTohome() {
        val intent = Intent(this, IntroProgrammingClassScreen ::class.java)
        startActivity(intent)
    }

}