package com.example.datacash.ui.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.databinding.FragmentServiceDemoBinding

class ServiceDemoFragment : Fragment() {

    private var _binding: FragmentServiceDemoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentServiceDemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Botón Atrás
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // Botón "Buscar Cuenta"
        binding.btnNextStep.setOnClickListener {
            val code = binding.etReferenceCode.text.toString()
            if (code.isEmpty()) {
                Toast.makeText(requireContext(), "Ingresa un código de referencia.", Toast.LENGTH_SHORT).show()
            } else {
                // Aquí iría la lógica para llamar a Firestore/API y buscar el recibo.
                Toast.makeText(requireContext(), "Buscando recibo con código: $code (DEMO)", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}