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
import com.example.datacash.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    // Declara la instancia de Firebase Authentication
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)

        // Inicializa Firebase Auth
        auth = Firebase.auth

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Botón principal de Registro
        binding.btnRegister.setOnClickListener {
            // 1. Obtenemos los datos del formulario
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val nombre = binding.etName.text.toString().trim()

            // 2. Validaciones simples
            if (email.isEmpty() || password.isEmpty() || nombre.isEmpty()) {
                Toast.makeText(requireContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.length < 6) {
                Toast.makeText(requireContext(), "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 3. ¡Aquí ocurre la magia! Llamamos a Firebase para crear el usuario.
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // ¡Registro exitoso!
                        Log.d("RegisterFragment", "createUserWithEmail:success")
                        Toast.makeText(requireContext(), "Cuenta creada con éxito.", Toast.LENGTH_SHORT).show()

                        // TODO: Aquí también guardaríamos el 'nombre' en la base de datos Firestore

                        // Navegamos a la pantalla de Login
                        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)

                    } else {
                        // Si el registro falla (ej. email ya existe)
                        Log.w("RegisterFragment", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(requireContext(), "Error al registrar: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                    }
                }
        }

        // Texto para ir a Login
        binding.tvGoToLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}