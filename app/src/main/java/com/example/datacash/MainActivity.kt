package com.example.datacash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen // 1. Import del Splash
import com.example.datacash.databinding.ActivityMainBinding // 2. Import del ViewBinding

// Los imports de 'enableEdgeToEdge' y 'ViewCompat' se han eliminado.

class MainActivity : AppCompatActivity() {

    // 3. Variable para ViewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // 4. Se llama al Splash PRIMERO
        installSplashScreen()

        // 5. Se llama a super.onCreate() DESPUÉS
        super.onCreate(savedInstanceState)

        // 6. Usamos ViewBinding para inflar el layout.
        //    (Esto reemplaza a enableEdgeToEdge, setContentView, y ViewCompat)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // A partir de aquí, en lugar de findViewById(R.id.main),
        // usarías 'binding.main' (si ese ID existiera en tu XML)
    }
}