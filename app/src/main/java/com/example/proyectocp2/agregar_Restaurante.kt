package com.example.proyecto

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectocp2.R

class AddRestaurantActivity : AppCompatActivity() {

    private lateinit var editTextRestaurantName: EditText
    private lateinit var editTextLocation: EditText
    private lateinit var ratingBar: RatingBar
    private lateinit var buttonSubmit: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agregar_restaurante)

        editTextRestaurantName = findViewById(R.id.editTextRestaurantName)
        editTextLocation = findViewById(R.id.editTextLocation)
        ratingBar = findViewById(R.id.ratingBar)
        buttonSubmit = findViewById(R.id.buttonSubmit)

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        buttonSubmit.setOnClickListener {
            addRestaurant()
        }
    }

    private fun addRestaurant() {
        val restaurantName = editTextRestaurantName.text.toString().trim()
        val location = editTextLocation.text.toString().trim()
        val rating = ratingBar.rating

        if (restaurantName.isEmpty() || location.isEmpty()) {
            Toast.makeText(this, "Por favor completa todos los campos.", Toast.LENGTH_SHORT).show()
            return
        }

        // Guardar la información en SharedPreferences (o en una base de datos)
        val editor = sharedPreferences.edit()
        editor.putString("restaurant_name", restaurantName)
        editor.putString("location", location)
        editor.putFloat("rating", rating)
        editor.apply()

        Toast.makeText(this, "Restaurante agregado con éxito.", Toast.LENGTH_SHORT).show()

        // Regresar a la actividad anterior
        finish()
    }
}
