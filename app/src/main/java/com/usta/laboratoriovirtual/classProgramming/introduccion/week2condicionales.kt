package com.usta.laboratoriovirtual.classProgramming.introduccion

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.usta.laboratoriovirtual.R

class week2condicionales : AppCompatActivity() {

    private lateinit var opcion1condicional: Button
    private lateinit var opcion2condicional: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week2condicionales)


        opcion1condicional = findViewById(R.id.opcion1condicional)
        opcion2condicional = findViewById(R.id.opcion2condicional)

        opcion1condicional.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            opcion1condicional.text = "Correcto"
            opcion1condicional.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed2))

        }


        opcion2condicional.setOnClickListener {
            // Cambiar texto y color cuando se presiona el botón
            opcion2condicional.text = "Incorrecto"
            opcion2condicional.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPressed))

        }
        }

}