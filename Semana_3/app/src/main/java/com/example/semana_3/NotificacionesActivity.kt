// NotificacionesActivity.kt
package com.example.semana_3

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NotificacionesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificaciones)

        // Obtener referencias
        val notificationsRecycler: RecyclerView? = findViewById(R.id.notificationsRecycler)
        val backButton: ImageButton? = findViewById(R.id.backButton)

        // Lista de notificaciones de ejemplo
        val notifications = listOf(
            Notification("Pago recibido", "Has recibido S/ 50.00 de Juan Pérez", "2 de Septiembre, 2025"),
            Notification("Recarga exitosa", "Recargaste S/ 20.00 a tu celular", "1 de Septiembre, 2025"),
            Notification("Compra realizada", "Compraste en Tienda Online: S/ 80.00", "30 de Agosto, 2025"),
            Notification("Envío de dinero", "Enviaste S/ 40.00 a María López", "28 de Agosto, 2025")
        )

        // Configurar RecyclerView
        notificationsRecycler?.layoutManager = LinearLayoutManager(this)
        notificationsRecycler?.adapter = NotificationAdapter(notifications)

        // Configurar botón atrás
        backButton?.setOnClickListener { finish() }
    }
}
