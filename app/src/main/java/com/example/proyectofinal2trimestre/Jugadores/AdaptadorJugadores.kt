package com.example.proyectofinal2trimestre.Jugadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal2trimestre.R
import com.example.proyectofinal2trimestre.databinding.HolderJugadoresBinding


class AdaptadorJugadores(val listado2: ArrayList<Jugador>) : RecyclerView.Adapter<AdaptadorJugadores.ClaseCelda2>() {

    inner class ClaseCelda2(val binding: HolderJugadoresBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClaseCelda2 {
        val contexto = parent.context
        val inflater = LayoutInflater.from(contexto)
        val binding = HolderJugadoresBinding.inflate(inflater, parent, false)
        val objetoVistaCelda2 = ClaseCelda2(binding)
        return objetoVistaCelda2

    }

    override fun getItemCount(): Int {
        return listado2.size
    }

    override fun onBindViewHolder(holder: ClaseCelda2, position: Int) {
        val jugador = listado2[position]


        holder.binding.imageView4.setImageResource(jugador.imagen)
        //holder.binding.
        holder.binding.nombrejugador.text = jugador.apodo.toString()
        holder.binding.posicionjugador.text = jugador.posicion.toString()


        holder.itemView.setOnClickListener {

            val bundle = bundleOf("jugador" to jugador)

//            Navigation.findNavController(it).navigate(R.id.action_playersFragment_to_playerDetailFragment)
            holder.itemView.findNavController().navigate(R.id.action_plantillaFragment_to_infoJugadorFragment,bundle)
        }
    }
}