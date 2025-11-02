package com.example.datacash.ui.send

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.R
import com.example.datacash.databinding.FragmentSendSuccessBinding

class SendSuccessFragment : Fragment() {

    private var _binding: FragmentSendSuccessBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSendSuccessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: Recibir los argumentos (monto y nombre) de la pantalla anterior
        // y mostrarlos en binding.tvSuccessSubtitle

        // Botón "Hecho"
        binding.btnDone.setOnClickListener {
            // Navega de vuelta al Dashboard, limpiando el historial de "Enviar"
            findNavController().navigate(R.id.action_sendSuccessFragment_to_dashboardFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}