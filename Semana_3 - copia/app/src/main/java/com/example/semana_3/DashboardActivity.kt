package com.example.semana_3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.cardview.widget.CardView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.dashboard)

        // Ajustar padding según las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dashboardLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias a las cards
        val cardEnviar: CardView = findViewById(R.id.cardEnviar)
        val cardRecargar: CardView = findViewById(R.id.cardRecargar)
        val cardRecibir: CardView = findViewById(R.id.cardRecibir)

        // Clicks en las cards
        cardEnviar.setOnClickListener {
            startActivity(Intent(this, EnviarActivity::class.java))
        }

        cardRecargar.setOnClickListener {
            startActivity(Intent(this, RecargarActivity::class.java))
        }

        cardRecibir.setOnClickListener {
            startActivity(Intent(this, RecibirActivity::class.java))
        }
    }
}
