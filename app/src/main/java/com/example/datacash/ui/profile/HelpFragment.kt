package com.example.datacash.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.databinding.FragmentHelpBinding

class HelpFragment : Fragment() {

    private var _binding: FragmentHelpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Lógica del botón "Atrás"
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // Lógica de los botones (placeholders)
        val clickListener = View.OnClickListener {
            Toast.makeText(requireContext(), "Función no implementada", Toast.LENGTH_SHORT).show()
        }

        binding.searchLayout.setOnClickListener(clickListener)
        binding.btnFaq1.setOnClickListener(clickListener)
        binding.btnFaq2.setOnClickListener(clickListener)
        binding.btnChat.setOnClickListener(clickListener)
        binding.btnEmail.setOnClickListener(clickListener)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}