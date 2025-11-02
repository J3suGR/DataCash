package com.example.datacash.ui.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.R
import com.example.datacash.databinding.FragmentStoreBinding

class StoreFragment : Fragment() {

    private var _binding: FragmentStoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // *** 1. LÓGICA DE CLICS (Placeholders) ***

        // Función de placeholder para los clics
        val storeItemClickListener = View.OnClickListener { v ->
            val itemName = when (v.id) {
                R.id.searchLayout -> "Buscar"
                R.id.cardPromo -> "Ver Promoción"
                R.id.btnStoreJuegos -> "Tienda de Juegos"
                R.id.btnStoreStreaming -> "Tienda de Streaming"
                R.id.btnStoreComida -> "Tienda de Comida"
                R.id.btnStoreRegalos -> "Tienda de Regalos"
                else -> "Item"
            }
            // TODO: Navegar a la pantalla de detalle del producto
            Toast.makeText(requireContext(), "$itemName no implementado", Toast.LENGTH_SHORT).show()
        }

        // Asignar el listener a todos los botones
        binding.searchLayout.setOnClickListener(storeItemClickListener)
        binding.cardPromo.setOnClickListener(storeItemClickListener)
        binding.btnStoreJuegos.setOnClickListener(storeItemClickListener)
        binding.btnStoreStreaming.setOnClickListener(storeItemClickListener)
        binding.btnStoreComida.setOnClickListener(storeItemClickListener)
        binding.btnStoreRegalos.setOnClickListener(storeItemClickListener)

        // *** 2. NAVEGACIÓN DE LA BARRA INFERIOR ***

        // Marcamos "Tienda" como seleccionado por defecto
        binding.bottomNavigation.selectedItemId = R.id.nav_tienda

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    findNavController().navigate(R.id.action_storeFragment_to_dashboardFragment)
                    true
                }
                R.id.nav_servicios -> {
                    findNavController().navigate(R.id.action_storeFragment_to_servicesFragment)
                    true
                }
                R.id.nav_tienda -> {
                    // Ya estamos aquí
                    true
                }
                R.id.nav_usuario -> {
                    findNavController().navigate(R.id.action_storeFragment_to_profileFragment)
                    true
                }
                else -> false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}