package com.usta.laboratoriovirtual.classProgramming.weeksPOO

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.usta.laboratoriovirtual.R
import com.usta.laboratoriovirtual.databinding.ActivityFirstBinding
import androidx.appcompat.app.AlertDialog

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding
    private lateinit var imageView: ImageView
    private lateinit var buttonClase: Button
    private lateinit var buttonObjeto: Button
    private lateinit var buttonAtributo: Button
    private lateinit var buttonMetodo: Button



    private val images = listOf(
        R.drawable.activitymetodos,
        R.drawable.activityclase,
        R.drawable.activityatributos,
        R.drawable.activityobjeto
    )
    private val correctAnswers = listOf(
        "Metodo",
        "Clase",
        "Atributo",
        "Objeto",

    )

    private var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageView = findViewById(R.id.question_image)
        buttonClase = findViewById(R.id.button_clase)
        buttonObjeto = findViewById(R.id.button_objeto)
        buttonAtributo = findViewById(R.id.button_atributo)
        buttonMetodo = findViewById(R.id.button_metodo)

        imageView.setImageResource(images[currentIndex])
        buttonMetodo.setOnClickListener{checkAnswer("Metodo")}
        buttonClase.setOnClickListener{checkAnswer("Clase")}
        buttonAtributo.setOnClickListener{checkAnswer("Atributo")}
        buttonObjeto.setOnClickListener{checkAnswer("Objeto")}

        val btnBack = findViewById<ImageButton>(R.id.back_button_main)


        btnBack.setOnClickListener{
            val intent = Intent(this, Week1Activity::class.java)
            startActivity(intent)
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.updatePadding(
                top = systemInsets.top,
                bottom = systemInsets.bottom
            )
            WindowInsetsCompat.CONSUMED
        }

    }

    private fun checkAnswer(answer: String){
        if (answer == correctAnswers[currentIndex]){
            Toast.makeText(this, "¡Correcto!", Toast.LENGTH_SHORT).show()

            currentIndex++
            if (currentIndex < images.size){
                imageView.setImageResource(images[currentIndex])
            }else {
                showCompletionDialog()
            }
        } else {
            Toast.makeText(this, "Intentalo de nuevo, ya casi lo logras", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showCompletionDialog() {
        AlertDialog.Builder(this)
            .setTitle("¡Felicidades!")
            .setMessage("Has terminado la actividad, puedes practicar las veces que hagan falta")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
                // Optionally, you can reset the activity
                currentIndex = 0
                imageView.setImageResource(images[currentIndex])
            }
            .show()
    }

}