package com.example.semana_3

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.util.Locale

class RecargarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recargar)

        // Ajustar paddings según status bar / navigation bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recargarLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backButton: ImageButton = findViewById(R.id.backButton)
        val rechargeButton: MaterialButton = findViewById(R.id.rechargeButton)
        val amountEditText: TextInputEditText = findViewById(R.id.amountEditText)
        val noteEditText: TextInputEditText = findViewById(R.id.noteEditText)

        backButton.setOnClickListener { finish() }

        rechargeButton.setOnClickListener {
            val amountText = amountEditText.text?.toString()?.trim().orEmpty()
            val noteText = noteEditText.text?.toString()?.trim().orEmpty()

            val amount = amountText.toDoubleOrNull()
            if (amount == null || amount <= 0.0) {
                Toast.makeText(this, "Por favor ingresa un monto válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val formattedAmount = String.format(Locale.getDefault(), "%.2f", amount)
            val message = "Recargando: S/ $formattedAmount\nNota: ${if (noteText.isEmpty()) "Ninguna" else noteText}"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()

            // Aquí iría la lógica real de recarga o navegación
        }
    }
}
