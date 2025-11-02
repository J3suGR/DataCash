package com.example.datacash.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.databinding.FragmentSecurityBinding

class SecurityFragment : Fragment() {

    private var _binding: FragmentSecurityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecurityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Lógica del botón "Atrás"
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // Lógica del botón "Actualizar Contraseña"
        binding.btnSaveChanges.setOnClickListener {
            // TODO: Lógica de ViewModel para verificar y cambiar la contraseña
            Toast.makeText(requireContext(), "Contraseña actualizada (simulación)", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack() // Regresa a la pantalla de Perfil
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}