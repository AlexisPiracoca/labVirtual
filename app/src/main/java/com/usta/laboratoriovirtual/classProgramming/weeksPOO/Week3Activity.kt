package com.usta.laboratoriovirtual.classProgramming.weeksPOO

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.usta.laboratoriovirtual.R
import com.usta.laboratoriovirtual.classProgramming.PooClassScreen

import com.usta.laboratoriovirtual.databinding.ActivityWeek3Binding

class Week3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityWeek3Binding
    private var isFrontVisible1 = true
    private var isFrontVisible2 = true
    private var isFrontVisible3 = true
    private var isFrontVisible4 = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWeek3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnBack = findViewById<ImageButton>(R.id.back_button_main)


        btnBack.setOnClickListener{
            val intent = Intent(this, PooClassScreen::class.java)
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


        val flipOut1 = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.flip_out)
        val flipOut2 = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.flip_out)
        val flipOut3 = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.flip_out)
        val flipOut4 = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.flip_out)
        val flopIn = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.flip_in)


        flipOut1.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                if (isFrontVisible1) {
                    binding.cardContainer.findViewById<LinearLayout>(R.id.card_front).visibility = View.GONE
                    binding.cardContainer.findViewById<LinearLayout>(R.id.card_back).visibility = View.VISIBLE
                } else {
                    binding.cardContainer.findViewById<LinearLayout>(R.id.card_front).visibility = View.VISIBLE
                    binding.cardContainer.findViewById<LinearLayout>(R.id.card_back).visibility = View.GONE
                }
                binding.cardContainer.startAnimation(flopIn)
                isFrontVisible1 = !isFrontVisible1
            }
            override fun onAnimationRepeat(animation: Animation?) {}
        })

        flipOut2.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                if (isFrontVisible2) {
                    binding.cardContainer1.findViewById<LinearLayout>(R.id.card_front1).visibility = View.GONE
                    binding.cardContainer1.findViewById<LinearLayout>(R.id.card_back1).visibility = View.VISIBLE
                } else {
                    binding.cardContainer1.findViewById<LinearLayout>(R.id.card_front1).visibility = View.VISIBLE
                    binding.cardContainer1.findViewById<LinearLayout>(R.id.card_back1).visibility = View.GONE
                }
                binding.cardContainer1.startAnimation(flopIn)
                isFrontVisible2 = !isFrontVisible2
            }
            override fun onAnimationRepeat(animation: Animation?) {}
        })

        flipOut3.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                if (isFrontVisible3) {
                    binding.cardContainer2.findViewById<LinearLayout>(R.id.card_front2).visibility = View.GONE
                    binding.cardContainer2.findViewById<LinearLayout>(R.id.card_back2).visibility = View.VISIBLE
                } else {
                    binding.cardContainer2.findViewById<LinearLayout>(R.id.card_front2).visibility = View.VISIBLE
                    binding.cardContainer2.findViewById<LinearLayout>(R.id.card_back2).visibility = View.GONE
                }
                binding.cardContainer2.startAnimation(flopIn)
                isFrontVisible3 = !isFrontVisible3
            }
            override fun onAnimationRepeat(animation: Animation?) {}
        })

        flipOut4.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                if (isFrontVisible4) {
                    binding.cardContainer3.findViewById<LinearLayout>(R.id.card_front3).visibility = View.GONE
                    binding.cardContainer3.findViewById<LinearLayout>(R.id.card_back3).visibility = View.VISIBLE
                } else {
                    binding.cardContainer3.findViewById<LinearLayout>(R.id.card_front3).visibility = View.VISIBLE
                    binding.cardContainer3.findViewById<LinearLayout>(R.id.card_back3).visibility = View.GONE
                }
                binding.cardContainer3.startAnimation(flopIn)
                isFrontVisible4 = !isFrontVisible4
            }
            override fun onAnimationRepeat(animation: Animation?) {}
        })

        //Encapsulamiento
        binding.cardContainer.findViewById<Button>(R.id.clase1).setOnClickListener {
            binding.cardContainer.startAnimation(flipOut1)
        }

        binding.cardContainer.findViewById<Button>(R.id.back_button).setOnClickListener {
            binding.cardContainer.startAnimation(flipOut1)
        }

        //Modificadores de acceso
        binding.cardContainer1.findViewById<Button>(R.id.clase2).setOnClickListener {
            binding.cardContainer1.startAnimation(flipOut2)
        }

        binding.cardContainer1.findViewById<Button>(R.id.back_button1).setOnClickListener {
            binding.cardContainer1.startAnimation(flipOut2)
        }

        //Ejemplo Encapsulamiento
        binding.cardContainer2.findViewById<Button>(R.id.clase3).setOnClickListener {
            binding.cardContainer2.startAnimation(flipOut3)
        }

        binding.cardContainer2.findViewById<Button>(R.id.back_button2).setOnClickListener {
            binding.cardContainer2.startAnimation(flipOut3)
        }
        //Tipos de MOdificadores de acceso

        binding.cardContainer3.findViewById<Button>(R.id.clase4).setOnClickListener {
            binding.cardContainer3.startAnimation(flipOut4)
        }

        binding.cardContainer3.findViewById<Button>(R.id.back_button3).setOnClickListener {
            binding.cardContainer3.startAnimation(flipOut4)
        }
    }
}