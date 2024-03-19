package com.example.proyectofinal2trimestre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.proyectofinal2trimestre.databinding.PopupOlvidarcontrasenaBinding

class PopUpOlvidarContrasena : Fragment() {

    private lateinit var binding: PopupOlvidarcontrasenaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PopupOlvidarcontrasenaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (binding.editTextTextEmailAddress != null){

            val correo = binding.editTextTextEmailAddress.text.toString()
            if (correo.verificarEmail()) {
                Toast.makeText(requireContext(), "Correo enviado a $correo", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Correo electrónico inválido", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun String.verificarEmail(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }
}