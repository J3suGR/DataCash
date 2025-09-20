package com.example.semana_3

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class ServicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_servicio)

        // Ajuste de paddings según sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.servicioLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias UI
        val backButton: ImageButton = findViewById(R.id.backButton)
        val payButton: MaterialButton = findViewById(R.id.payButton)
        val serviceNameEditText: TextInputEditText = findViewById(R.id.serviceNameEditText)
        val serviceCodeEditText: TextInputEditText = findViewById(R.id.serviceCodeEditText)
        val amountEditText: TextInputEditText = findViewById(R.id.amountEditText)
        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        // Botón atrás
        backButton.setOnClickListener { finish() }

        // Botón pagar
        payButton.setOnClickListener {
            val serviceName = serviceNameEditText.text?.toString()?.trim().orEmpty()
            val serviceCode = serviceCodeEditText.text?.toString()?.trim().orEmpty()
            val amount = amountEditText.text?.toString()?.trim().orEmpty()

            if (serviceName.isEmpty() || serviceCode.isEmpty() || amount.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val amountValue = amount.toDoubleOrNull()
            if (amountValue == null || amountValue <= 0.0) {
                Toast.makeText(this, "Monto inválido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val message = "Pagando $serviceName\nCódigo: $serviceCode\nMonto: S/ $amountValue"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

        // Bottom Navigation
        bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_dashboard -> {
                    startActivity(Intent(this, DashboardActivity::class.java))
                    true
                }
                R.id.nav_servicios -> true
                R.id.nav_tienda -> {
                    startActivity(Intent(this, TiendaActivity::class.java))
                    true
                }
                else -> false
            }
        }
        bottomNav.selectedItemId = R.id.nav_servicios
    }
}
