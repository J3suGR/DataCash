package com.example.datacash.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.R
import com.example.datacash.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- SOLO LOS BOTONES QUE ESTÁN DENTRO DEL DASHBOARD ---

        // 1. Botón de Notificaciones
        binding.ivNotifications.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_notifications)
        }

        // 2. Botón de Enviar
        binding.btnSend.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_selectRecipient)
        }

        // 3. Botón de Recibir
        binding.btnReceive.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_receiveMoney)
        }

        // 4. Botón de "Ver más" transacciones
        binding.btnViewMore.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_transactions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}