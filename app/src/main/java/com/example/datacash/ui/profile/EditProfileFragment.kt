package com.example.datacash.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.databinding.FragmentEditProfileBinding

class EditProfileFragment : Fragment() {

    private var _binding: FragmentEditProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Lógica del botón "Atrás"
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // Lógica del botón "Guardar Cambios"
        binding.btnSaveChanges.setOnClickListener {
            // TODO: Lógica de ViewModel para guardar los datos
            Toast.makeText(requireContext(), "Cambios guardados (simulación)", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack() // Regresa a la pantalla de Perfil
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}