package com.example.semana_3

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class TiendaActivity : AppCompatActivity() {

    private lateinit var productsRecycler: RecyclerView
    private lateinit var shopButton: MaterialButton
    private lateinit var backButton: ImageButton

    private val productList = listOf(
        Product("Auriculares Bluetooth", "S/ 120.00", R.drawable.ic_store),
        Product("Mouse Gamer RGB", "S/ 80.00", R.drawable.ic_store),
        Product("Teclado Mecánico", "S/ 150.00", R.drawable.ic_store),
        Product("Power Bank 20000mAh", "S/ 95.00", R.drawable.ic_store),
        Product("Smartwatch Deportivo", "S/ 220.00", R.drawable.ic_store)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tienda)

        productsRecycler = findViewById(R.id.productsRecycler)
        shopButton = findViewById(R.id.shopButton)
        backButton = findViewById(R.id.backButton)
        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        // Usar GridLayoutManager en lugar de LinearLayoutManager
        productsRecycler.layoutManager = GridLayoutManager(this, 2)
        productsRecycler.adapter = ProductAdapter(productList) { product ->
            Toast.makeText(this, "${product.name} agregado al carrito", Toast.LENGTH_SHORT).show()
        }

        shopButton.setOnClickListener {
            Toast.makeText(this, "Carrito en desarrollo 🚀", Toast.LENGTH_SHORT).show()
        }

        backButton.setOnClickListener { finish() }

        bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_dashboard -> {
                    startActivity(Intent(this, DashboardActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_servicios -> {
                    startActivity(Intent(this, ServicioActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_tienda -> true
                else -> false
            }
        }

        bottomNav.selectedItemId = R.id.nav_tienda
    }
}
