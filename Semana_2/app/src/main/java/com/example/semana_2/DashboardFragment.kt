package com.example.semana_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dashboard, container, false)

        // Botones principales
        val btnRecargar = view.findViewById<Button>(R.id.btnRecargar)
        val btnEnviar = view.findViewById<Button>(R.id.btnEnviar)
        val btnRecibir = view.findViewById<Button>(R.id.btnRecibir)

        btnRecargar.setOnClickListener { openFragment(RecargarFragment()) }
        btnEnviar.setOnClickListener { openFragment(EnviarFragment()) }
        btnRecibir.setOnClickListener { openFragment(RecibirFragment()) }

        // Botones de accesos rápidos
        val btnServicios = view.findViewById<Button>(R.id.btnServicios)
        val btnTienda = view.findViewById<Button>(R.id.btnTienda)
        val btnHistorial = view.findViewById<Button>(R.id.btnHistorial)
        val btnNotificaciones = view.findViewById<Button>(R.id.btnNotificaciones)

        btnServicios.setOnClickListener { openFragment(ServiciosFragment()) }
        btnTienda.setOnClickListener { openFragment(TiendaFragment()) }
        btnHistorial.setOnClickListener { openFragment(HistorialFragment()) }
        btnNotificaciones.setOnClickListener { openFragment(NotificacionesFragment()) }

        return view
    }

    private fun openFragment(fragment: Fragment) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, fragment)
            ?.addToBackStack(null)  // permite volver al dashboard con el botón atrás
            ?.commit()
    }
}
