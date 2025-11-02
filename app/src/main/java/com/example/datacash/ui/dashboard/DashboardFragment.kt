package com.example.datacash.ui.dashboard // <- Asegúrate de que este 'package' coincida con tu nueva estructura

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.R
import com.example.datacash.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    // Variable para manejar el ViewBinding del fragmento
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Infla el layout (fragment_dashboard.xml)
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // *** 1. NAVEGACIÓN DE BOTONES SUPERIORES ***

        // Botón de Notificaciones (Campana)
        binding.ivNotifications.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_notifications)
        }

        // Botón de Enviar (Tarjeta de Acción)
        binding.btnSend.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_selectRecipient)
        }

        // Botón de Recibir (Tarjeta de Acción)
        binding.btnReceive.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_receiveMoney)
        }

        // Botón de "Ver más" (Transacciones)
        binding.btnViewMore.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_transactions)
        }

        // *** 2. NAVEGACIÓN DE LA BARRA INFERIOR (BottomNavigationView) ***

        // Marcamos "Home" como seleccionado por defecto (ya que este es el Home)
        binding.bottomNavigation.selectedItemId = R.id.nav_home

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                // Caso 1: Clic en "Home" (No hacemos nada, ya estamos aquí)
                R.id.nav_home -> {
                    true // Devuelve true para indicar que se manejó el clic
                }

                // Caso 2: Clic en "Servicios"
                R.id.nav_servicios -> {
                    findNavController().navigate(R.id.action_dashboard_to_services)
                    true
                }

                // Caso 3: Clic en "Tienda"
                R.id.nav_tienda -> {
                    findNavController().navigate(R.id.action_dashboard_to_store)
                    true
                }

                // Caso 4: Clic en "Usuario"
                R.id.nav_usuario -> {
                    findNavController().navigate(R.id.action_dashboard_to_profile)
                    true
                }

                else -> false
            }
        }
    }

    // Limpia el binding para evitar fugas de memoria
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}