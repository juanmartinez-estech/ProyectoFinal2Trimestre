package com.example.proyectofinal2trimestre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectofinal2trimestre.databinding.PlantillaLayoutBinding

class PlantillaFragment : Fragment() {

    private lateinit var binding: PlantillaLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PlantillaLayoutBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val valero = Jugador(R.drawable.valero, 1, "Valero", "Portero")
        val abraham = Jugador(R.drawable.abraham, 1, "Abraham", "Portero")

        val cabrejas = Jugador(R.drawable.cabrejas, 1, "Cabrejas", "Defensa")
        val danigallego = Jugador(R.drawable.danigallego, 1, "Dani Gallego", "Defensa")
        val galiano = Jugador(R.drawable.galiano, 1, "Galiano", "Defensa")
        val joseba = Jugador(R.drawable.joseba, 1, "Joseba", "Defensa")
        val maxi = Jugador(R.drawable.maxi, 1, "Maxi", "Defensa")
        val niza = Jugador(R.drawable.niza, 1, "Niza", "Defensa")
        val rosales = Jugador(R.drawable.rosales, 1, "Rosales", "Defensa")

        val balle = Jugador(R.drawable.balle, 1, "Balle", "Centrocampista")
        val felipe = Jugador(R.drawable.felipe, 1, "Felipe", "Centrocampista")
        val salido = Jugador(R.drawable.salido, 1, "Salido", "Centrocampista")
        val sebasfranco = Jugador(R.drawable.sebasfranco, 1, "Sebas Franco", "Centrocampista")

        val adrihumanes = Jugador(R.drawable.adrihumanes, 1, "Adri Humanes", "Delantero")
        val alberto = Jugador(R.drawable.alberto, 1, "Alberto", "Delantero")
        val chaquetas = Jugador(R.drawable.chaquetas, 1, "Chaquetas", "Delantero")
        val fran = Jugador(R.drawable.fran, 1, "Fran", "Delantero")
        val ikaro = Jugador(R.drawable.ikaro, 1, "Ikaro", "Delantero")
        val mauri = Jugador(R.drawable.mauri, 1, "Mauri", "Delantero")
        val pedrocobo = Jugador(R.drawable.pedrocobo, 1, "Pedro Cobo", "Delantero")

        val toni = Jugador(R.drawable.tonigarcia, 1, "Toni Garcia", "Entrenador")
        val chipi = Jugador(R.drawable.chipi, 1, "Chipi", "Segundo Entrenador")
        val jesusruiz = Jugador(R.drawable.jesusruiz, 1, "Jesús Ruiz", "Delegado de Equipo")
        val carlosjaviersanchez = Jugador(R.drawable.carlosjaviersanchez, 1, "Carlos Javier Sanchez", "Delegado de Equipo")

        val arrayJugador = ArrayList<Jugador>()

        arrayJugador.add(valero)
        arrayJugador.add(abraham)

        arrayJugador.add(cabrejas)
        arrayJugador.add(danigallego)
        arrayJugador.add(galiano)
        arrayJugador.add(joseba)
        arrayJugador.add(maxi)
        arrayJugador.add(niza)
        arrayJugador.add(rosales)

        arrayJugador.add(balle)
        arrayJugador.add(felipe)
        arrayJugador.add(salido)
        arrayJugador.add(sebasfranco)

        arrayJugador.add(adrihumanes)
        arrayJugador.add(alberto)
        arrayJugador.add(chaquetas)
        arrayJugador.add(fran)
        arrayJugador.add(ikaro)
        arrayJugador.add(mauri)
        arrayJugador.add(pedrocobo)

        arrayJugador.add(toni)
        arrayJugador.add(chipi)
        arrayJugador.add(jesusruiz)
        arrayJugador.add(carlosjaviersanchez)

        val glm = GridLayoutManager(requireContext(), 2)
//        val layoutManager = LinearLayoutManager(requireContext())
        val adaptador = AdaptadorJugadores(arrayJugador)

        binding.recyclerView2.layoutManager = glm
        binding.recyclerView2.adapter = adaptador



    }
}