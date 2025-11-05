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
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

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

        // 1. Botón "Editar Perfil"
        binding.btnEditProfile.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
        }

        // 2. Botón "Seguridad"
        binding.btnSecurity.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_securityFragment)
        }

        // 3. Botón "Ayuda y Soporte"
        binding.btnHelp.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_helpFragment)
        }

        // 4. Botón "Cerrar Sesión"
        binding.btnLogout.setOnClickListener {
            // Cerramos sesión en Firebase
            Firebase.auth.signOut()

            // Mostramos un mensaje
            Toast.makeText(requireContext(), "Sesión cerrada", Toast.LENGTH_SHORT).show()

            // Navegamos de vuelta a la pantalla de bienvenida
            findNavController().navigate(R.id.action_profileFragment_to_welcomeFragment)
        }

        // (NOTA: Se eliminó todo el bloque 'bottomNavigation'
        // porque ahora MainActivity lo maneja automáticamente)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}