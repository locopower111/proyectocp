package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectocp2.R

class ChoiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitychoice)

        val buttonRestaurants: Button = findViewById(R.id.buttonRestaurants)
        val buttonFoods: Button = findViewById(R.id.buttonFoods)

        buttonRestaurants.setOnClickListener {
            // Aquí puedes añadir lógica para mostrar restaurantes
        }

        buttonFoods.setOnClickListener {
            // Aquí puedes añadir lógica para mostrar comidas
            }
        }
}