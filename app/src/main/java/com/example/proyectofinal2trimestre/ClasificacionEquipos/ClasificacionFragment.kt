package com.example.proyectofinal2trimestre.ClasificacionEquipos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectofinal2trimestre.R
import com.example.proyectofinal2trimestre.databinding.ClasificacionBinding

class ClasificacionFragment : Fragment() {

    private lateinit var binding: ClasificacionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ClasificacionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val villacarrillo = Equipo(1, "Villacarrillo AOVE", 52, 24, R.drawable.villacarrillo)
        val carolinense = Equipo(2, "Carolinense C.D.", 49, 24, R.drawable.carolinense)
        val navas = Equipo(3, "C.D. Navas", 47, 24, R.drawable.navas)
        val begijar = Equipo(4, "Begijar C.F.", 47, 24, R.drawable.begijar)
        val interjaen = Equipo(5, "Inter de Jaén C.F.", 41, 24, R.drawable.interjaen)
        val atleticojaen = Equipo(6, "Atlético Jaén F.C.", 40, 24, R.drawable.atleticojaen)
        val hispania = Equipo(7, "C.D. Hispania", 34, 24, R.drawable.hispania)
        val vilches = Equipo(8, "C.D. Vilches", 30, 24, R.drawable.vilches)
        val cazorla = Equipo(9, "U.D. Cazorla", 30, 24, R.drawable.cazorla)
        val baeza = Equipo(10, "Baeza C.F", 29, 24, R.drawable.baeza)
        val villanueva = Equipo(11, "C.D. Villanueva Arz", 28, 24, R.drawable.villanueva)
        val torredonjimenoB = Equipo(12, "UDC Torredonjimeno B", 27, 24, R.drawable.torredonjimeno)
        val rus = Equipo(13, "CD Rus EF", 25, 24, R.drawable.rus)
        val lopera = Equipo(14, "A.D. Lopera", 21, 24, R.drawable.lopera)
        val atleticomengibar = Equipo(15, "Atlético Mengíbar", 20, 24, R.drawable.atleticomengibar)
        val mancharealB = Equipo(16, "A. Mancha Real B", 11, 24, R.drawable.manchareal)

        val arrayEquipo = ArrayList<Equipo>()

        arrayEquipo.add(villacarrillo)
        arrayEquipo.add(carolinense)
        arrayEquipo.add(navas)
        arrayEquipo.add(begijar)
        arrayEquipo.add(interjaen)
        arrayEquipo.add(atleticojaen)
        arrayEquipo.add(hispania)
        arrayEquipo.add(vilches)
        arrayEquipo.add(cazorla)
        arrayEquipo.add(baeza)
        arrayEquipo.add(villanueva)
        arrayEquipo.add(torredonjimenoB)
        arrayEquipo.add(rus)
        arrayEquipo.add(lopera)
        arrayEquipo.add(atleticomengibar)
        arrayEquipo.add(mancharealB)


        val layoutManager = LinearLayoutManager(requireContext())
        val adaptador = AdaptadorClasificacion(arrayEquipo)

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adaptador

    }
}