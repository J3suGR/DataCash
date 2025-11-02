package com.example.datacash.ui.send

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.R
import com.example.datacash.databinding.FragmentSelectRecipientBinding

class SelectRecipientFragment : Fragment() {

    private var _binding: FragmentSelectRecipientBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectRecipientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Botón "Atrás"
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // Lógica de la barra de búsqueda (placeholder)
        binding.searchLayout.setOnClickListener {
            Toast.makeText(requireContext(), "Búsqueda no implementada", Toast.LENGTH_SHORT).show()
        }

        // Lógica de la lista
        // TODO: Reemplazar este LinearLayout con un RecyclerView
        // Por ahora, haremos que el primer item de la lista (incluido estáticamente)
        // nos lleve a la siguiente pantalla.

        // Obtenemos el primer hijo del LinearLayout
        val firstRecipient = binding.listRecipients.getChildAt(0)
        firstRecipient?.setOnClickListener {
            // Navegamos a la pantalla de "Ingresar Monto"
            findNavController().navigate(R.id.action_selectRecipientFragment_to_sendMoneyFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}