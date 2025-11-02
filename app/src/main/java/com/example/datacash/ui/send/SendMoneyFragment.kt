package com.example.datacash.ui.send

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.datacash.R
import com.example.datacash.databinding.FragmentSendMoneyBinding
import java.text.DecimalFormat

class SendMoneyFragment : Fragment() {

    private var _binding: FragmentSendMoneyBinding? = null
    private val binding get() = _binding!!

    // Variable para guardar el monto que se está escribiendo
    private val currentAmount = StringBuilder("0")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSendMoneyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Botón "Atrás"
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // Botón "Enviar"
        binding.btnSend.setOnClickListener {
            // TODO: Lógica de ViewModel para enviar el 'currentAmount' al backend

            // Navegamos a la pantalla de Éxito
            findNavController().navigate(R.id.action_sendMoneyFragment_to_sendSuccessFragment)
        }

        // --- Lógica del Teclado Numérico ---
        setupNumpad()
    }

    private fun setupNumpad() {
        // Recorremos todos los botones del GridLayout
        binding.keypadGrid.children.forEach { button ->
            when (button.id) {
                // Caso del botón de Borrar (ImageButton)
                R.id.btnBackspace -> { // (Necesitarás añadir este ID a tu ImageButton en el XML)
                    (button as ImageButton).setOnClickListener { onBackspaceClick() }
                }
                // Caso de los botones numéricos
                else -> {
                    (button as Button).setOnClickListener {
                        onNumpadClick(button.text.toString())
                    }
                }
            }
        }

        // NOTA: Si no quieres añadir IDs, puedes usar getChildAt(index)
        // Ejemplo: binding.keypadGrid.getChildAt(11).setOnClickListener { onBackspaceClick() }
        // Pero es menos seguro. Es mejor añadir IDs a los botones del numpad.
    }

    private fun onNumpadClick(digit: String) {
        // Lógica para añadir el dígito
        if (currentAmount.toString() == "0" && digit != ".") {
            currentAmount.clear()
        }

        // Evitar múltiples puntos decimales
        if (digit == "." && currentAmount.contains(".")) {
            return
        }

        currentAmount.append(digit)
        updateAmountDisplay()
    }

    private fun onBackspaceClick() {
        // Lógica para borrar
        if (currentAmount.length > 1) {
            currentAmount.deleteCharAt(currentAmount.length - 1)
        } else if (currentAmount.length == 1) {
            currentAmount.clear()
            currentAmount.append("0")
        }
        updateAmountDisplay()
    }

    private fun updateAmountDisplay() {
        // Formatea el texto para mostrar "S/. 50.00" o "S/. 0"
        try {
            val amountAsDouble = currentAmount.toString().toDoubleOrNull() ?: 0.0
            val formatter = DecimalFormat("S/. #,##0.00")
            if (currentAmount.toString() == "0") {
                binding.tvAmount.text = "S/. 0"
            } else {
                // Esta lógica simple es para la vista, no para el cálculo real
                binding.tvAmount.text = "S/. $currentAmount"
            }
        } catch (e: Exception) {
            binding.tvAmount.text = "S/. 0"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}