package com.example.proyectocp2

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectocp2.R

class ChoiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

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