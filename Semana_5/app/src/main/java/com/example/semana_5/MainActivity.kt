package com.example.semana_5

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.PI
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.ejemplo02)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Función para calcular el área del triángulo
    fun calcularAreaTriangulo(view: View) {
        val base: Double = findViewById<EditText>(R.id.txtBase).text.toString().toDoubleOrNull() ?: 0.0
        val altura: Double = findViewById<EditText>(R.id.txtAltura).text.toString().toDoubleOrNull() ?: 0.0

        val area: Double = base * altura / 2.0
        findViewById<EditText>(R.id.txtAreaTriangulo).setText("Área: %.2f".format(area))
    }

    // Función para calcular el área lateral, área total y volumen del tronco de cono
    fun calcularAreaCono(view: View) {
        val radioSuperior = findViewById<EditText>(R.id.txtRadioSuperior).text.toString().toDoubleOrNull() ?: 0.0
        val radioInferior = findViewById<EditText>(R.id.txtRadioInferior).text.toString().toDoubleOrNull() ?: 0.0
        val altura = findViewById<EditText>(R.id.txtAlturaCono).text.toString().toDoubleOrNull() ?: 0.0
        val generatriz = findViewById<EditText>(R.id.txtGeneratriz).text.toString().toDoubleOrNull() ?: 0.0

        // Calculamos el área lateral
        val areaLateral = PI * (radioSuperior + radioInferior) * generatriz

        // Calculamos el área total
        val areaBaseSuperior = PI * radioSuperior.pow(2)
        val areaBaseInferior = PI * radioInferior.pow(2)
        val areaTotal = areaLateral + areaBaseSuperior + areaBaseInferior

        // Calculamos el volumen
        val volumen = (1 / 3.0) * PI * altura * (radioSuperior.pow(2) + radioSuperior * radioInferior + radioInferior.pow(2))

        // Mostramos los resultados
        findViewById<EditText>(R.id.txtAreaLateral).setText("Área Lateral: %.2f".format(areaLateral))
        findViewById<EditText>(R.id.txtAreaTotal).setText("Área Total: %.2f".format(areaTotal))
        findViewById<EditText>(R.id.txtVolumen).setText("Volumen: %.2f".format(volumen))
    }

    fun calcularAreaCubo(view: View) {
        val lado = findViewById<EditText>(R.id.txtLadoCubo).text.toString().toDoubleOrNull() ?: 0.0
        val areaCubo = 6 * lado.pow(2)
        findViewById<EditText>(R.id.txtAreaCubo).setText("Área del Cubo: %.2f".format(areaCubo))
    }

    fun calcularAreaOrtoedro(view: View) {
        val largo = findViewById<EditText>(R.id.txtLargoOrtoedro).text.toString().toDoubleOrNull() ?: 0.0
        val ancho = findViewById<EditText>(R.id.txtAnchoOrtoedro).text.toString().toDoubleOrNull() ?: 0.0
        val alto = findViewById<EditText>(R.id.txtAltoOrtoedro).text.toString().toDoubleOrNull() ?: 0.0
        val areaOrtoedro = 2 * (largo * ancho + largo * alto + ancho * alto)
        findViewById<EditText>(R.id.txtAreaOrtoedro).setText("Área del Ortoedro: %.2f".format(areaOrtoedro))
    }

}
