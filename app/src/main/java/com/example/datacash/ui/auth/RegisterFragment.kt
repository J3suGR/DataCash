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
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        auth = Firebase.auth
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val nombre = binding.etName.text.toString().trim()

            if (email.isEmpty() || password.isEmpty() || nombre.isEmpty()) {
                Toast.makeText(requireContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.length < 6) {
                Toast.makeText(requireContext(), "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // PASO A: Crear el usuario
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("RegisterFragment", "createUserWithEmail:success")

                        // ¡ÉXITO! Ahora enviamos el email de verificación
                        enviarEmailDeVerificacion()

                        // TODO: Aquí también guardaríamos el 'nombre' en la base de datos Firestore

                    } else {
                        // Si el registro falla (ej. email ya existe)
                        Log.w("RegisterFragment", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(requireContext(), "Error al registrar: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                    }
                }
        }

        binding.tvGoToLogin.setOnClickListener {
            // Esta "flecha" (action) debe existir en tu nav_graph.xml
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    // **********************************
    // ** ¡ESTA ES LA LÓGICA QUE FALTABA! **
    // **********************************
    private fun enviarEmailDeVerificacion() {
        val user = auth.currentUser

        // PASO B: Enviar el email de verificación
        user?.sendEmailVerification()
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("RegisterFragment", "Email de verificación enviado.")
                    Toast.makeText(requireContext(), "¡Registro exitoso! Revisa tu email para verificar la cuenta.", Toast.LENGTH_LONG).show()

                    // Navegamos a la nueva pantalla "VerifyEmailFragment"
                    // (Esta "flecha" debe existir en tu nav_graph.xml)
                    findNavController().navigate(R.id.action_registerFragment_to_verifyEmailFragment)

                } else {
                    Log.e("RegisterFragment", "sendEmailVerification:failure", task.exception)
                    Toast.makeText(requireContext(), "Error al enviar email de verificación.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}