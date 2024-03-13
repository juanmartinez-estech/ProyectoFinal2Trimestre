package com.example.proyectofinal2trimestre.Jugadores

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.proyectofinal2trimestre.databinding.HolderInfojugadoresBinding
import com.example.proyectofinal2trimestre.databinding.PlantillaLayoutBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class InfoJugadorFragment : Fragment() {

    private lateinit var binding: HolderInfojugadoresBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HolderInfojugadoresBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jugador =  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable("jugador", Jugador::class.java)
        } else {
            arguments?.getParcelable("jugador")
        }

        jugador?.let { rellenaDatos(it) }
    }

    private fun rellenaDatos(j: Jugador){
        with(binding) {
            apodoinfo.text = j.apodo
            imageninfo.setImageResource(j.imagen)
            nombreinfo.text = j.nombre
            apellidosinfo.text = j.apellidos
            edadinfo.text = getAge(j.fecha)
            numeroinfo.text = j.numero.toString()
            pesoinfo.text = j.peso.toString()
            alturainfo.text = j.altura.toString()
            observacionesinfo.text = j.observaciones
        }
    }

    private fun getAge(birthday: String): String {
        val dob = Calendar.getInstance()
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val formattedDate = sdf.parse(birthday)
        formattedDate?.let {
            dob.time = it
            val today = Calendar.getInstance()
            var age = today[Calendar.YEAR] - dob[Calendar.YEAR]
            if (today[Calendar.DAY_OF_YEAR] < dob[Calendar.DAY_OF_YEAR]) {
                age--
            }
            return "$age años ($birthday)"
        }
        return birthday
    }
}