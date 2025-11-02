package com.example.datacash.ui.receive

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.databinding.FragmentReceiveMoneyBinding

class ReceiveMoneyFragment : Fragment() {

    private var _binding: FragmentReceiveMoneyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReceiveMoneyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- Lógica del QR Code ---
        // TODO: Aquí irá la lógica para generar el QR del usuario
        // y mostrarlo en binding.ivQrCode
        // Por ahora, el XML muestra un placeholder.


        // --- Lógica de Botones ---

        // 1. Botón "Atrás"
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // 2. Botón "Compartir Código"
        binding.btnShareQr.setOnClickListener {
            compartirCodigo()
        }
    }

    private fun compartirCodigo() {
        // TODO: En el futuro, aquí compartirás la IMAGEN del QR.
        // Por ahora, compartiremos el texto del usuario.

        val userName = binding.tvUserName.text.toString() // "Para: Juan Perez"
        val textoParaCompartir = "¡Recibe dinero en DataCash! Búscame como $userName."

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, textoParaCompartir)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, "Compartir mi código vía...")
        startActivity(shareIntent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}