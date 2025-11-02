package com.example.datacash.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.R
import com.example.datacash.databinding.FragmentVerifyEmailBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class VerifyEmailFragment : Fragment() {

    private var _binding: FragmentVerifyEmailBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVerifyEmailBinding.inflate(inflater, container, false)
        auth = Firebase.auth
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Botón "Ya lo verifiqué, continuar"
        binding.btnCheckVerification.setOnClickListener {
            // 1. Recargamos el estado del usuario desde Firebase
            auth.currentUser?.reload()?.addOnSuccessListener {
                val user = auth.currentUser

                // 2. Comprobamos si el email ya está verificado
                if (user?.isEmailVerified == true) {
                    Toast.makeText(requireContext(), "¡Cuenta verificada! Ya puedes iniciar sesión.", Toast.LENGTH_LONG).show()
                    // Lo enviamos al Login (limpiando el historial)
                    findNavController().navigate(R.id.action_verifyEmailFragment_to_loginFragment)
                } else {
                    Toast.makeText(requireContext(), "Aún no has verificado tu email. Por favor, revisa tu bandeja de entrada.", Toast.LENGTH_LONG).show()
                }
            }
        }

        // Botón "Reenviar Email"
        binding.btnResendEmail.setOnClickListener {
            auth.currentUser?.sendEmailVerification()?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(requireContext(), "Email de verificación reenviado.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Error al reenviar el email.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}