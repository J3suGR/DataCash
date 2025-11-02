package com.example.datacash.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.R
import com.example.datacash.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    // Declara la instancia de Firebase Authentication
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Inicializa Firebase Auth
        auth = Firebase.auth

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Botón principal de Login
        binding.btnLogin.setOnClickListener {
            // 1. Obtenemos los datos
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            // 2. Validación
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Ingresa email y contraseña", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 3. ¡Magia de Firebase! Llamamos para iniciar sesión.
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // ¡Login exitoso!
                        Log.d("LoginFragment", "signInWithEmail:success")

                        // Navegamos al Dashboard (¡y limpiamos el historial para que no pueda "volver" al login!)
                        findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)

                    } else {
                        // Si el login falla (ej. contraseña incorrecta)
                        Log.w("LoginFragment", "signInWithEmail:failure", task.exception)
                        Toast.makeText(requireContext(), "Error: Credenciales incorrectas.", Toast.LENGTH_SHORT).show()
                    }
                }
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