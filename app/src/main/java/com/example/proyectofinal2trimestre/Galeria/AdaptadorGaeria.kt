package com.example.proyectofinal2trimestre.Galeria

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal2trimestre.databinding.HolderImagenesBinding

class AdaptadorGaeria(val listado3: ArrayList<GaeriaData>) : RecyclerView.Adapter<AdaptadorGaeria.ClaseCelda>() {

    inner class ClaseCelda(val binding: HolderImagenesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClaseCelda {
        val contexto = parent.context
        val inflater = LayoutInflater.from(contexto)
        val binding = HolderImagenesBinding.inflate(inflater, parent, false)
        val objetoVistaCelda = ClaseCelda(binding)
        return objetoVistaCelda
    }

    override fun getItemCount(): Int {
        return listado3.size
    }

    override fun onBindViewHolder(holder: ClaseCelda, position: Int) {
        val imagen = listado3[position]

        holder.binding.imagengaleria.setImageResource(imagen.imagen)
    }

}