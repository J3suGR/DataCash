package com.example.semana_1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.semana_1.ui.theme.Semana_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Semana_1Theme {
                AndroidView(
                    modifier = Modifier.fillMaxSize(),
                    factory = { context ->
                        val root = LayoutInflater.from(context)
                            .inflate(R.layout.practicasemana1, null, false)

                        // Botones principales
                        val btnRecargar = root.findViewById<Button>(R.id.btnRecargar)
                        val btnEnviar   = root.findViewById<Button>(R.id.btnEnviar)
                        val btnRecibir  = root.findViewById<Button>(R.id.btnRecibir)

                        // Navegación a Activities
                        btnRecargar.setOnClickListener {
                            startActivity(Intent(this@MainActivity, RecargarActivity::class.java))
                        }
                        btnEnviar.setOnClickListener {
                            startActivity(Intent(this@MainActivity, EnviarActivity::class.java))
                        }
                        btnRecibir.setOnClickListener {
                            startActivity(Intent(this@MainActivity, RecibirActivity::class.java))
                        }

                        root
                    }
                )
            }
        }
    }
}
