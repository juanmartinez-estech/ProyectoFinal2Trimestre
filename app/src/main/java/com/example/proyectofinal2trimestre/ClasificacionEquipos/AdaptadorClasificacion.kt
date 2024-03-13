package com.example.proyectofinal2trimestre.ClasificacionEquipos

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal2trimestre.databinding.HolderEquiposBinding

class AdaptadorClasificacion(val listado: ArrayList<Equipo>) : RecyclerView.Adapter<AdaptadorClasificacion.ClaseCelda>() {

    inner class ClaseCelda(val binding: HolderEquiposBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClaseCelda {
        val contexto = parent.context
        val inflater = LayoutInflater.from(contexto)
        val binding = HolderEquiposBinding.inflate(inflater, parent, false)
        val objetoVistaCelda = ClaseCelda(binding)
        return objetoVistaCelda
    }

    override fun getItemCount(): Int {
        return listado.size
    }

    override fun onBindViewHolder(holder: ClaseCelda, position: Int) {
        val equipo = listado[position]

        holder.binding.nombreequipo.text = equipo.nombre
        holder.binding.posicion.text = equipo.posicion.toString()
        holder.binding.puntos.text = equipo.puntos.toString()
        holder.binding.partidosjugados.text = equipo.partidosjugados.toString()
        holder.binding.imageView2.setImageResource(equipo.imagen)

//        Glide.with(holder.itemView)
//            .load(persona.imagen)
//            .into(holder.binding.imageView)

//        con este detecta cuando pinchas en la imagen
//        holder.binding.imageView.setOnClickListener {
//            eliminar(position)
//        }

//        con este detecta cuando pinchas en toda la caja
//        holder.itemView.setOnClickListener {
//            eliminar(position)
//        }


        if (position == 0 || position == 1 || position == 2 || position == 3) {
            holder.binding.posicion.setBackgroundColor(Color.GREEN)
            holder.binding.posicion.setTextColor(Color.WHITE)
        }else if (position == 4 || position == 5 || position == 6 || position == 7){
            holder.binding.posicion.setBackgroundColor(Color.BLUE)
            holder.binding.posicion.setTextColor(Color.WHITE)
        }else if (position == 8 || position == 9 || position == 10 || position == 11 || position == 12){
            holder.binding.posicion.setBackgroundColor(Color.WHITE)
            holder.binding.posicion.setTextColor(Color.BLACK)
        }else if (position == 13 || position == 14 || position == 15){
            holder.binding.posicion.setBackgroundColor(Color.RED)
            holder.binding.posicion.setTextColor(Color.WHITE)
        }

    }
}