package com.example.proyectofinal2trimestre

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.proyectofinal2trimestre.databinding.ContactoLayoutBinding


class ContactoFragment : Fragment() {

    private lateinit var binding: ContactoLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ContactoLayoutBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        binding.botonmaps.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("geo:38.09434215597427, -3.6312645311104648?z=16&q=38.09434215597427, -3.6312645311104648(Linares)")
            )
            intent.setClassName(
                "com.google.android.apps.maps",
                "com.google.android.maps.MapsActivity"
            )
            startActivity(intent)
        }

        binding.botonemail1.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto: info@escuelaestech.es")
                putExtra(Intent.EXTRA_SUBJECT, "Hola")
            }
            try {
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(requireContext(), "La aplicacion de Gmail no esta instalada", Toast.LENGTH_SHORT).show()
            }
        }

        binding.botonemail2.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto: info@escuelaestech.es")
                putExtra(Intent.EXTRA_SUBJECT, "Hola")
            }
            try {
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(requireContext(), "La aplicacion de Gmail no esta instalada", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btTelefono.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel: 953 636 000")
            }
            try {
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(requireContext(), "La aplicacion de Telefono no esta instalada", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btWats.setOnClickListener {
            val numeroTel = "+34697246008"
            val intent = Intent(Intent.ACTION_VIEW)
            val uri = "whatsapp://send?phone=$numeroTel"
            intent.setData(Uri.parse(uri))
            try {
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(requireContext(), "La aplicacion de Whastapp no esta instalada", Toast.LENGTH_SHORT).show()
            }

        }


        if (binding.tietNombre != null && binding.tietCorreo != null && binding.tietTelefono != null && binding.tietMensaje != null && binding.chboxPolitica.isChecked){
            binding.btEnviar.isClickable = true

            binding.btEnviar.setOnClickListener {
                val correo = binding.tietCorreo.text.toString()
                if (correo.verificarEmail()) {
                    val correoelectronico = binding.tietCorreo.text
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto: $correoelectronico")
                        putExtra(Intent.EXTRA_SUBJECT, "Hola")
                    }
                    try {
                        startActivity(intent)
                    } catch (ex: ActivityNotFoundException) {
                        Toast.makeText(requireContext(), "La aplicacion de Gmail no esta instalada", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Correo electrónico inválido", Toast.LENGTH_SHORT).show()
                }
            }

        }



    }

    private fun String.verificarEmail(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }



}