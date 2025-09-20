package com.example.semana_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.example.semana_3.R

class EnviarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Infla el layout activity_enviar.xml
        setContentView(R.layout.activity_enviar)

        // Obtiene referencias a los elementos de la interfaz de usuario
        val backButton: ImageButton = findViewById(R.id.backButton)
        val continueButton: MaterialButton = findViewById(R.id.continueButton)
        val phoneNumberEditText: TextInputEditText = findViewById(R.id.phoneNumberEditText)
        val amountEditText: TextInputEditText = findViewById(R.id.amountEditText)
        val noteEditText: TextInputEditText = findViewById(R.id.noteEditText)

        // Configura el oyente de clic para el botón de volver
        backButton.setOnClickListener {
            finish() // Cierra la actividad y regresa a la pantalla anterior
        }

        // Configura el oyente de clic para el botón "Continuar"
        continueButton.setOnClickListener {
            val phoneNumber = phoneNumberEditText.text.toString()
            val amount = amountEditText.text.toString()
            val note = noteEditText.text.toString()

            // Muestra un mensaje temporal (Toast) para confirmar los datos ingresados
            val message = "Enviar a: $phoneNumber\nMonto: $amount\nNota: $note"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()

            // Aquí es donde agregarías la lógica real para procesar el envío de dinero.
            // Por ejemplo:
            // val intent = Intent(this, ConfirmacionActivity::class.java)
            // intent.putExtra("phone_number", phoneNumber)
            // startActivity(intent)
        }
    }
}
