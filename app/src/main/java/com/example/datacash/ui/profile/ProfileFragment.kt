package com.example.datacash.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.R
import com.example.datacash.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // *** 1. NAVEGACIÓN DE LA LISTA DE OPCIONES ***

        // Botón "Editar Perfil"
        binding.btnEditProfile.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
        }

        // Botón "Seguridad"
        binding.btnSecurity.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_securityFragment)
        }

        // Botón "Ayuda y Soporte"
        binding.btnHelp.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_helpFragment)
        }

        // *** 2. BOTÓN DE CERRAR SESIÓN ***
        binding.btnLogout.setOnClickListener {
            // TODO: Aquí irá la lógica para limpiar la sesión guardada

            // Navegamos de vuelta a la pantalla de bienvenida
            findNavController().navigate(R.id.action_profileFragment_to_welcomeFragment)
        }

        // *** 3. NAVEGACIÓN DE LA BARRA INFERIOR (BottomNavigationView) ***

        // Marcamos "Usuario" como seleccionado por defecto
        binding.bottomNavigation.selectedItemId = R.id.nav_usuario

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    findNavController().navigate(R.id.action_profileFragment_to_dashboardFragment)
                    true
                }
                R.id.nav_servicios -> {
                    findNavController().navigate(R.id.action_profileFragment_to_servicesFragment)
                    true
                }
                R.id.nav_tienda -> {
                    findNavController().navigate(R.id.action_profileFragment_to_storeFragment)
                    true
                }
                R.id.nav_usuario -> {
                    // Ya estamos aquí, no hacemos nada
                    true
                }
                else -> false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}