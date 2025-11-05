package com.example.datacash.ui.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.datacash.R
import com.example.datacash.databinding.FragmentServicesBinding

class ServicesFragment : Fragment() {

    private var _binding: FragmentServicesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentServicesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- LÓGICA DE CLICS PARA LOS SERVICIOS ---
        val serviceClickListener = View.OnClickListener { v ->
            // Determinamos el nombre del servicio basado en el ID del botón presionado
            val serviceName = when (v.id) {
                R.id.btnSavedServiceLuz -> "Mis Recibos de Luz"
                R.id.btnSavedServiceInternet -> "Mi Internet Hogar"
                R.id.btnServiceLuz -> "Pagar Luz"
                R.id.btnServiceAgua -> "Pagar Agua"
                R.id.btnServiceWifi -> "Pagar Wifi"
                R.id.btnServiceCable -> "Pagar Cable"
                R.id.btnServiceTelefono -> "Pagar Teléfono"
                R.id.btnServiceGas -> "Pagar Gas"
                R.id.btnOtherServices -> "Ver Otros Servicios"
                else -> "Servicio desconocido"
            }

            // TODO: Aquí navegarías a la pantalla de pago específica.
            // Por ahora, mostramos un mensaje.
            Toast.makeText(requireContext(), "Seleccionaste: $serviceName", Toast.LENGTH_SHORT).show()
        }

        // Asignamos el mismo "oyente" a todos los botones
        binding.btnSavedServiceLuz.setOnClickListener(serviceClickListener)
        binding.btnSavedServiceInternet.setOnClickListener(serviceClickListener)
        binding.btnServiceLuz.setOnClickListener(serviceClickListener)
        binding.btnServiceAgua.setOnClickListener(serviceClickListener)
        binding.btnServiceWifi.setOnClickListener(serviceClickListener)
        binding.btnServiceCable.setOnClickListener(serviceClickListener)
        binding.btnServiceTelefono.setOnClickListener(serviceClickListener)
        binding.btnServiceGas.setOnClickListener(serviceClickListener)
        binding.btnOtherServices.setOnClickListener(serviceClickListener)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}