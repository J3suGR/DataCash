package com.example.datacash.ui.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.databinding.FragmentStoreDemoBinding

class StoreDemoFragment : Fragment() {

    private var _binding: FragmentStoreDemoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStoreDemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Botón Atrás
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // Aquí podrías recibir argumentos para cambiar el título según qué botón se presionó.
        // Por ejemplo: binding.tvPageTitle.text = arguments?.getString("category_name")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}