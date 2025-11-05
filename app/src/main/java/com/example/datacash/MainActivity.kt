package com.example.datacash

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.datacash.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Sincronización visual básica
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController)

        // --- LISTENER CON LÓGICA DE DIRECCIÓN DINÁMICA ---
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val currentId = navController.currentDestination?.id
            val newId = item.itemId

            // Si no hay destino actual o es el mismo, no hacemos nada
            if (currentId == null || currentId == newId) {
                return@setOnItemSelectedListener true
            }

            // 1. Obtener posiciones
            val currentPos = getTabPosition(currentId)
            val newPos = getTabPosition(newId)

            // 2. Determinar dirección (si alguna posición es -1, usar animación por defecto hacia derecha)
            val isMovingRight = if (currentPos != -1 && newPos != -1) {
                newPos > currentPos
            } else {
                true
            }

            // 3. Configurar animaciones según la dirección
            val enterAnim = if (isMovingRight) R.anim.slide_in_right else R.anim.slide_in_left
            val exitAnim = if (isMovingRight) R.anim.slide_out_left else R.anim.slide_out_right
            // Las animaciones 'pop' (volver atrás) suelen ser inversas
            val popEnterAnim = if (isMovingRight) R.anim.slide_in_left else R.anim.slide_in_right
            val popExitAnim = if (isMovingRight) R.anim.slide_out_right else R.anim.slide_out_left

            val navOptions = NavOptions.Builder()
                .setEnterAnim(enterAnim)
                .setExitAnim(exitAnim)
                .setPopEnterAnim(popEnterAnim)
                .setPopExitAnim(popExitAnim)
                .setPopUpTo(navController.graph.startDestinationId, false) // Mantiene el historial limpio
                .setLaunchSingleTop(true)
                .build()

            // 4. Navegar
            try {
                navController.navigate(newId, null, navOptions)
                true
            } catch (e: Exception) {
                false
            }
        }

        // Control de visibilidad del menú (Igual que antes)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.dashboardFragment,
                R.id.servicesFragment,
                R.id.storeFragment,
                R.id.profileFragment -> {
                    binding.bottomNavigation.visibility = View.VISIBLE
                }
                else -> {
                    binding.bottomNavigation.visibility = View.GONE
                }
            }
        }
    }

    // Función auxiliar para saber el orden de las pestañas
    private fun getTabPosition(destinationId: Int): Int {
        return when (destinationId) {
            R.id.dashboardFragment -> 0  // Posición 0 (Izquierda extrema)
            R.id.servicesFragment -> 1   // Posición 1
            R.id.storeFragment -> 2      // Posición 2
            R.id.profileFragment -> 3    // Posición 3 (Derecha extrema)
            else -> -1 // No es una pestaña principal
        }
    }
}