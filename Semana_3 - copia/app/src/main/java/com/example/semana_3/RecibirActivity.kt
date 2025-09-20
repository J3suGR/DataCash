package com.example.semana_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class RecibirActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recibir)

        val backButton: ImageButton = findViewById(R.id.backButton)
        val shareButton: MaterialButton = findViewById(R.id.shareButton)

        backButton.setOnClickListener {
            finish()
        }

        shareButton.setOnClickListener {
            Toast.makeText(this, "Funcionalidad para compartir QR en desarrollo", Toast.LENGTH_SHORT).show()
        }
    }
}
