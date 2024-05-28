package com.usta.laboratoriovirtual.classProgramming.weeksPOO

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.usta.laboratoriovirtual.R

class SecondActivity : AppCompatActivity() {
    private lateinit var questionTextView: TextView
    private lateinit var option1Button: Button
    private lateinit var option2Button: Button
    private lateinit var option3Button: Button
    private lateinit var option4Button: Button
    private var currentQuestionIndex = 0




    private val questions by lazy {
        arrayOf(
            getString(R.string.question_1),
            getString(R.string.question_2),
            getString(R.string.question_3),
            getString(R.string.question_4)
        )
    }

    private val options by lazy {
        arrayOf(
            resources.getStringArray(R.array.options_question_1),
            resources.getStringArray(R.array.options_question_2),
            resources.getStringArray(R.array.options_question_3),
            resources.getStringArray(R.array.options_question_4)
        )
    }

    private val correctAnswers = intArrayOf(0, 0, 0, 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnBack = findViewById<ImageButton>(R.id.back_button_main)


        btnBack.setOnClickListener{
            val intent = Intent(this, Week2Activity::class.java)
            startActivity(intent)
            finish()
        }

        questionTextView = findViewById(R.id.questionTextView)
        option1Button = findViewById(R.id.option1Button)
        option2Button = findViewById(R.id.option2Button)
        option3Button = findViewById(R.id.option3Button)
        option4Button = findViewById(R.id.option4Button)

        loadNextQuestion()

        option1Button.setOnClickListener { checkAnswer(0) }
        option2Button.setOnClickListener { checkAnswer(1) }
        option3Button.setOnClickListener { checkAnswer(2) }
        option4Button.setOnClickListener { checkAnswer(3) }


    }

    private fun loadNextQuestion() {
        if (currentQuestionIndex < questions.size) {
            questionTextView.text = questions[currentQuestionIndex]
            option1Button.text = options[currentQuestionIndex][0]
            option2Button.text = options[currentQuestionIndex][1]
            option3Button.text = options[currentQuestionIndex][2]
            option4Button.text = options[currentQuestionIndex][3]
        } else {
            questionTextView.text = "¡Has completado el quiz!"
            option1Button.visibility = Button.GONE
            option2Button.visibility = Button.GONE
            option3Button.visibility = Button.GONE
            option4Button.visibility = Button.GONE

            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, Week2Activity::class.java)
                startActivity(intent)
                finish()
            }, 2000)
        }
    }

    private fun checkAnswer(selectedOptionIndex: Int) {
        if (selectedOptionIndex == correctAnswers[currentQuestionIndex]) {
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
        }
        currentQuestionIndex++
        loadNextQuestion()
    }
}
