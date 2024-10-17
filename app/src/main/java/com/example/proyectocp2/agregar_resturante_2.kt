package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectocp2.R

class ThankYouActivity : AppCompatActivity() {

    private lateinit var buttonBackToMenu: Button
    private lateinit var buttonAddAnother: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thank_you)

        buttonBackToMenu = findViewById(R.id.buttonBackToMenu)
        buttonAddAnother = findViewById(R.id.buttonAddAnother)

        buttonBackToMenu.setOnClickListener {
            // Regresar al menú principal
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Opcional: para cerrar la actividad actual
        }

        buttonAddAnother.setOnClickListener {
            // Regresar a la actividad de agregar restaurante
            val intent = Intent(this, AddRestaurantActivity::class.java)
            startActivity(intent)
            finish() // Opcional: para cerrar la actividad actual
        }
    }
}
