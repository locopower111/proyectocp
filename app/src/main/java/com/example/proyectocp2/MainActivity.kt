package com.example.proyecto

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.proyectocp2.R
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var buttonRegister: Button
    private lateinit var buttonLogin: Button
    private lateinit var textViewMessage: TextView
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var welcomeView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextUsername = findViewById(R.id.editTextUsername)
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonLogin = findViewById(R.id.buttonLogin)
        textViewMessage = findViewById(R.id.textViewMessage)

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // Inflar la vista del diálogo
        welcomeView = layoutInflater.inflate(R.layout.dialog_welcome, null)
        welcomeView.visibility = View.GONE  // Ocultar inicialmente

        // Añadir la vista de bienvenida al layout principal
        (findViewById<ConstraintLayout>(R.id.mainLayout)).addView(welcomeView)

        buttonRegister.setOnClickListener {
            // Redirigir a RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            showWelcomeMessage()  // Mostrar el mensaje de bienvenida
        }

        buttonLogin.setOnClickListener {
            val savedUsername = sharedPreferences.getString("username", null)
            val enteredUsername = editTextUsername.text.toString().trim()

            if (enteredUsername.isEmpty()) {
                showSnackbar("Por favor, introduce un nombre de usuario.")
                return@setOnClickListener
            }

            if (savedUsername != null && savedUsername == enteredUsername) {
                textViewMessage.text = "Bienvenido, $enteredUsername"
            } else {
                textViewMessage.text = "Usuario no encontrado. Regístrate primero."
            }

            editTextUsername.text.clear()
        }
    }

    private fun showWelcomeMessage() {
        welcomeView.visibility = View.VISIBLE
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
        }
}