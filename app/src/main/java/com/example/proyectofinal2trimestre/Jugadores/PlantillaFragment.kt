package com.example.proyectofinal2trimestre.Jugadores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.proyectofinal2trimestre.R
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

        val valero = Jugador(R.drawable.valero,"Valero", "Portero", "Andrés", "Valero Pozas", "06/11/1974", 1, 87, 181, "Suele tener una regularidad pero quizás por destacar algo es muy sobrio, va bien por arriba y juega bastante con los pies.")
        val abraham = Jugador(R.drawable.abraham, "Abraham", "Portero", "Abraham", "Berzosa Secaduras", "09/12/2007", 23, 60, 180, "")

        val cabrejas = Jugador(R.drawable.cabrejas,"Cabrejas", "Defensa", "Francisco Manuel", "Cabrejas Navarrete", "16/01/1994", 2, 70, 175, "Jugador fuerte en defensa,sale mui bien al corte,hábil.buena tecnica,rapido.en el uno contra uno siempre sale ganando,en fin jugador completo." )
        val danigallego = Jugador(R.drawable.danigallego,"Dani Gallego", "Defensa", "Daniel", "Gallego Flores", "21/04/2002", 3, 0, 175, "")
        val galiano = Jugador(R.drawable.galiano,  "Galiano", "Defensa", "Fernando", "Galiano Martínez", "13/11/2001", 4, 78, 192, "Jugador con una gran proyección, se inició en posiciones más ofensivas, donde solía hacer bastantes goles, en las 3 últimas temporadas se ha afianzado en la posición de central, donde se ha adaptado perfectamente, técnicamente bien dotado, maneja las 2 piernas, con buen desplazamiento de balón y seguro en el juego aéreo, suele incorporarse al ataque en las acciones a balón parado, creando bastante peligro.")
        val joseba = Jugador(R.drawable.joseba,"Joseba", "Defensa", "Joseba", "Rogel Lopezosa", "30/09/2004", 5, 75, 177, "")
        val maxi = Jugador(R.drawable.maxi,"Maxi", "Defensa", "", "", "", 0, 0 ,0 ,"")
        val niza = Jugador(R.drawable.niza,"Niza", "Defensa", "", "", "", 0, 0 ,0 ,"")
        val rosales = Jugador(R.drawable.rosales,"Rosales", "Defensa", "", "", "", 0, 0 ,0 ,"")

        val balle = Jugador(R.drawable.balle,"Balle", "Centrocampista", "", "", "", 0, 0 ,0 ,"")
        val felipe = Jugador(R.drawable.felipe,"Felipe", "Centrocampista", "", "", "", 0, 0 ,0 ,"")
        val salido = Jugador(R.drawable.salido,"Salido", "Centrocampista", "", "", "", 0, 0 ,0 ,"")
        val sebasfranco = Jugador(R.drawable.sebasfranco,"Sebas Franco", "Centrocampista", "", "", "", 0, 0 ,0 ,"")

        val adrihumanes = Jugador(R.drawable.adrihumanes,"Adri Humanes", "Delantero", "", "", "", 0, 0 ,0 ,"")
        val alberto = Jugador(R.drawable.alberto, "Alberto", "Delantero", "", "", "", 0, 0 ,0 ,"")
        val chaquetas = Jugador(R.drawable.chaquetas, "Chaquetas", "Delantero", "", "", "", 0, 0 ,0 ,"")
        val fran = Jugador(R.drawable.fran, "Fran", "Delantero", "", "", "", 0, 0 ,0 ,"")
        val ikaro = Jugador(R.drawable.ikaro,  "Ikaro", "Delantero", "", "", "", 0, 0 ,0 ,"")
        val mauri = Jugador(R.drawable.mauri, "Mauri", "Delantero", "", "", "", 0, 0 ,0 ,"")
        val pedrocobo = Jugador(R.drawable.pedrocobo, "Pedro Cobo", "Delantero", "", "", "", 0, 0 ,0 ,"")

        val toni = Jugador(R.drawable.tonigarcia, "Toni Garcia", "Entrenador", "", "", "", 0, 0 ,0 ,"")
        val chipi = Jugador(R.drawable.chipi, "Chipi", "Segundo Entrenador", "", "", "", 0, 0 ,0 ,"")
        val jesusruiz = Jugador(R.drawable.jesusruiz, "Jesús Ruiz", "Delegado de Equipo", "", "", "", 0, 0 ,0 ,"")
        val carlosjaviersanchez = Jugador(R.drawable.carlosjaviersanchez, "Carlos Javier Sanchez", "Delegado de Equipo", "", "", "", 0, 0 ,0 ,"")

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