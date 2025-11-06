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

        // LÓGICA DE CLICS
        // Listener para los botones de categoría que navegan a la Demo
        val openDemoListener = View.OnClickListener {
            // Navega al fragmento de demostración de la tienda.
            // Asegúrate que el ID R.id.action_storeFragment_to_storeDemoFragment
            // esté correctamente definido en nav_graph.xml (lo está en la revisión anterior).
            findNavController().navigate(R.id.action_storeFragment_to_storeDemoFragment)
        }

        // Asignar el listener de navegación a los botones de productos
        binding.btnStoreJuegos.setOnClickListener(openDemoListener)
        binding.btnStoreStreaming.setOnClickListener(openDemoListener)
        binding.btnStoreComida.setOnClickListener(openDemoListener)
        binding.btnStoreRegalos.setOnClickListener(openDemoListener)

        // Listeners separados para elementos que no navegan todavía (solo Toast)
        binding.searchLayout.setOnClickListener {
            Toast.makeText(requireContext(), "Búsqueda no implementada", Toast.LENGTH_SHORT).show()
        }

        binding.cardPromo.setOnClickListener {
            Toast.makeText(requireContext(), "Promoción no disponible", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}