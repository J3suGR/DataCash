package com.example.datacash.ui.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController // Importación necesaria para la navegación
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

        // LÓGICA DE CLICS (Ahora navega al DEMO)
        val serviceClickListener = View.OnClickListener { v ->
            // Determinamos el nombre del servicio (opcional, útil para debugging o argumentos)
            val serviceName = when (v.id) {
                R.id.btnSavedServiceLuz -> "Mis Recibos de Luz"
                R.id.btnSavedServiceInternet -> "Mi Internet Hogar"
                R.id.btnServiceLuz -> "Luz"
                R.id.btnServiceAgua -> "Agua"
                R.id.btnServiceWifi -> "Wifi"
                R.id.btnServiceCable -> "Cable"
                R.id.btnServiceTelefono -> "Teléfono"
                R.id.btnServiceGas -> "Gas"
                R.id.btnOtherServices -> "Otros Servicios"
                else -> "Servicio"
            }

            // Navegamos a la demo usando la acción definida en nav_graph.xml
            findNavController().navigate(R.id.action_servicesFragment_to_serviceDemoFragment)

            // Opcionalmente, puedes usar Toast para confirmar que la navegación se ha activado:
            // Toast.makeText(requireContext(), "Navegando a la demo para: $serviceName", Toast.LENGTH_SHORT).show()
        }

        // Asignar el listener a todos los botones
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