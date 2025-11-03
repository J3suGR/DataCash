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

        // **********************************
        // ** ¡AQUÍ ESTÁ LA CORRECCIÓN 1! **
        // ** 1. ESTABLECEMOS EL TEXTO **
        // **********************************
        // TODO: En el futuro, recibirás este texto de la pantalla anterior (argumentos de navegación).
        binding.tvSuccessSubtitle.text = "Has enviado S/. 99.00 a Juan Perez"


        // Botón "Hecho"
        binding.btnDone.setOnClickListener {
            findNavController().navigate(R.id.action_sendSuccessFragment_to_dashboardFragment)
        }

        // 2. LLAMAMOS A LA ANIMACIÓN
        fadeInViews()
    }

    private fun fadeInViews() {
        val duration = 1600L // Duración del fade-in

        // **********************************
        // ** ¡AQUÍ ESTÁ LA CORRECCIÓN 2! **
        // ** 3. ANIMAMOS EL ICONO **
        // **********************************
        // Hacemos aparecer el contenedor del icono
        binding.iconContainer.animate().alpha(1f).setDuration(duration).start()

        // Hacemos aparecer el texto y el botón
        binding.tvSuccessTitle.animate().alpha(1f).setDuration(duration).start()
        binding.tvSuccessSubtitle.animate().alpha(1f).setDuration(duration).start()
        binding.btnDone.animate().alpha(1f).setDuration(duration).start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}