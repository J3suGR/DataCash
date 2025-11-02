package com.example.datacash.ui.transactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.databinding.FragmentTransactionsBinding

class TransactionsFragment : Fragment() {

    private var _binding: FragmentTransactionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Infla el layout (fragment_transactions.xml)
        _binding = FragmentTransactionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- Lógica de Botones ---

        // 1. Botón "Atrás"
        binding.ivBack.setOnClickListener {
            // Regresa a la pantalla anterior (Dashboard)
            findNavController().popBackStack()
        }

        // 2. Barra de Búsqueda (placeholder)
        binding.searchLayout.setOnClickListener {
            // TODO: Implementar lógica de búsqueda
            Toast.makeText(requireContext(), "Búsqueda no implementada", Toast.LENGTH_SHORT).show()
        }

        // 3. Lógica de la lista (placeholder)
        // TODO: Reemplazar este LinearLayout con un RecyclerView
        // Por ahora, solo hacemos que el primer item sea clickable
        val firstItem = binding.listTransactions.getChildAt(0)
        firstItem?.setOnClickListener {
            Toast.makeText(requireContext(), "Viendo detalle de transacción (no implementado)", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}