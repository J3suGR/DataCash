package com.example.semana_3

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView

// Nuevos imports para el RecyclerView y los datos
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
import com.example.semana_3.R

// Define la clase de datos para una transacción
data class Transaction(
    val description: String,
    val amount: Double,
    val isDebit: Boolean,
    val date: Date,
    val iconResId: Int
)

// Crea el adaptador para el RecyclerView
class TransactionAdapter(private val transactions: List<Transaction>) :
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    class TransactionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val descriptionTextView: TextView = view.findViewById(R.id.transactionDescription)
        val amountTextView: TextView = view.findViewById(R.id.transactionAmount)
        val dateTextView: TextView = view.findViewById(R.id.transactionDate)
        val iconImageView: ImageView = view.findViewById(R.id.transactionIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transaction_card, parent, false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.descriptionTextView.text = transaction.description
        holder.amountTextView.text = if (transaction.isDebit) {
            String.format("-S/ %.2f", transaction.amount)
        } else {
            String.format("+S/ %.2f", transaction.amount)
        }
        holder.amountTextView.setTextColor(
            if (transaction.isDebit) {
                holder.itemView.context.resources.getColor(android.R.color.holo_red_dark, null)
            } else {
                holder.itemView.context.resources.getColor(android.R.color.holo_green_dark, null)
            }
        )

        val dateFormat = SimpleDateFormat("dd 'de' MMM, yyyy", Locale("es", "ES"))
        holder.dateTextView.text = dateFormat.format(transaction.date)
        holder.iconImageView.setImageResource(transaction.iconResId)
    }

    override fun getItemCount() = transactions.size
}

// La actividad principal del dashboard
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
        val cardRecibir: CardView = findViewById(R.id.cardServicios)

        // Referencia al botón de notificaciones
        val notificationsButton: ImageButton = findViewById(R.id.notificationsButton)

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

        // Click en el botón de notificaciones
        notificationsButton.setOnClickListener {
            startActivity(Intent(this, NotificacionesActivity::class.java))
        }

        // Bottom Navigation
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_dashboard -> true // Ya estamos aquí
                R.id.nav_servicios -> {
                    startActivity(Intent(this, ServicioActivity::class.java))
                    true
                }
                R.id.nav_tienda -> {
                    startActivity(Intent(this, TiendaActivity::class.java))
                    true
                }
                else -> false
            }
        }

        // ---
        // Configuración para el RecyclerView de transacciones
        val recyclerView: RecyclerView = findViewById(R.id.historialRecycler)

        // Crear datos simulados para las transacciones
        val transactions = listOf(
            Transaction("Compra en el supermercado", 150.00, true, Date(System.currentTimeMillis()), R.drawable.ic_shopping_cart),
            Transaction("Depósito de sueldo", 2500.00, false, Date(System.currentTimeMillis() - 86400000), R.drawable.ic_send_money),
            Transaction("Pago de servicio de internet", 120.00, true, Date(System.currentTimeMillis() - 2 * 86400000), R.drawable.ic_wifi),
            Transaction("Transferencia de María", 50.00, false, Date(System.currentTimeMillis() - 3 * 86400000), R.drawable.ic_person_in),
            Transaction("Cena en restaurante", 85.50, true, Date(System.currentTimeMillis() - 4 * 86400000), R.drawable.ic_restaurant)
        )

        // Configurar el RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TransactionAdapter(transactions)
        // ---
    }
}
