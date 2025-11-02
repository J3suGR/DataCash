package com.example.datacash.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.R
import com.example.datacash.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Botón principal de Login
        binding.btnLogin.setOnClickListener {
            // TODO: Aquí irá la lógica de ViewModel para verificar el login.
            // Por ahora, navegaremos directo al Dashboard para probar.
            findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
        }

        // Texto para ir a Registro
        binding.tvGoToRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        // Texto de "Olvide mi contraseña"
        binding.tvForgotPassword.setOnClickListener {
            // TODO: Crear el Fragment y la Acción para "Olvide mi contraseña"
            Toast.makeText(requireContext(), "Función 'Olvide mi contraseña' no implementada", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}