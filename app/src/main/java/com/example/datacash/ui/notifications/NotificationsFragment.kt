package com.example.datacash.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Infla el layout (fragment_notifications.xml)
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Lógica del botón "Atrás"
        binding.ivBack.setOnClickListener {
            // Regresa a la pantalla anterior (Dashboard)
            findNavController().popBackStack()
        }

        // 2. Lógica del botón "Leído" (placeholder)
        binding.tvMarkAsRead.setOnClickListener {
            // TODO: Añadir lógica para marcar todas las notificaciones como leídas
            Toast.makeText(requireContext(), "Marcando todo como leído...", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}