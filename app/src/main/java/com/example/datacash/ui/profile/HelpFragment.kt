package com.example.datacash.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.databinding.FragmentHelpBinding

class HelpFragment : Fragment() {

    private var _binding: FragmentHelpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Lógica del botón "Atrás"
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // Lógica de la barra de búsqueda (placeholder)
        binding.searchLayout.setOnClickListener {
            Toast.makeText(requireContext(), "Búsqueda no implementada", Toast.LENGTH_SHORT).show()
        }

        // --- LÓGICA DE ACORDEÓN ---

        // Pregunta Frecuente 1
        binding.btnFaq1.setOnClickListener {
            toggleAccordion(binding.contentFaq1)
        }

        // Pregunta Frecuente 2
        binding.btnFaq2.setOnClickListener {
            toggleAccordion(binding.contentFaq2)
        }

        // Contacto: Chat
        binding.btnChat.setOnClickListener {
            toggleAccordion(binding.contentChat)
        }

        // Contacto: Email
        binding.btnEmail.setOnClickListener {
            toggleAccordion(binding.contentEmail)
        }
    }

    /**
     * Función para mostrar u ocultar un TextView (efecto acordeón)
     */
    private fun toggleAccordion(contentView: View) {
        if (contentView.visibility == View.GONE) {
            contentView.visibility = View.VISIBLE
        } else {
            contentView.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}