package com.example.proyectofinal2trimestre

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.proyectofinal2trimestre.databinding.HomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: HomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val misPreferencias = requireContext().getSharedPreferences("myprefs", Context.MODE_PRIVATE)
        val usersaved = misPreferencias.getString("user", "")

        binding.usuario.text = usersaved

        var contador = 0
        val imagenclickable = true

        binding.imagenescudo.isClickable = imagenclickable
        binding.imagenescudo.setOnClickListener {
            contador++
            if (contador==10){
                imagenclickable == false


                val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
                builder
                    .setTitle("Enhorabuena")

                    .setPositiveButton("Positive") { dialog, which ->
                        val builder = AlertDialog.Builder(requireContext())
                        builder.setTitle("Mensaje del sistema")
                        builder.setMessage("Enhorabuena este el el codigo para canjear el premio: 123132DFD")
                        builder.setPositiveButton("Gracias", DialogInterface.OnClickListener {
                                dialog, i ->
                        })
                        val dialog = builder.create() //AlertDialog
                        dialog.show()
                    }
                    .setNegativeButton("Negative") { dialog, which ->
                        // Do something else.
                    }
                    .setSingleChoiceItems(
                        arrayOf("Foto con el equipo", "Video personalizado de cumleaños", "Abono gratis"), 0
                    ) { dialog, which ->
                        // Do something.
                    }

                val dialog: AlertDialog = builder.create()
                dialog.show()
            }
        }

    }
}